package com.will.first.service.util;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Component
public class RedisLockUtil {

    @Resource(name = "lock")
    DefaultRedisScript<Long> lockRedisScript;

    @Resource(name = "unlock")
    DefaultRedisScript<Long> unlockRedisScript;

    @Resource(name="stringRedisTemplate")
    StringRedisTemplate redisTemplate;

    public Long lock(String key, String value, String ttl){
        List<String> keys = Arrays.asList(key);
        return redisTemplate.execute(lockRedisScript, keys, value, ttl);
    }

    public Long unlock(String key, String value){
        List<String> keys = Arrays.asList(key);
        return redisTemplate.execute(unlockRedisScript, keys, value);
    }

}
