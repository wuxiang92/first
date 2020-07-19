-- Set a lock
--  如果获取锁成功，则返回 1
local key     = KEYS[1]
local content = ARGV[1]
local ttl     = tonumber(ARGV[2])
local lockSet = redis.call('setnx', key, content)
if lockSet == 1 then
  redis.call('PEXPIRE', key, ttl)
else
  -- 如果value相同，则认为是同一个线程的请求，则认为重入锁
  local value = redis.call('get', key)
  if(value == content) then
    lockSet = 1;
    redis.call('PEXPIRE', key, ttl)
  end
end
return lockSet