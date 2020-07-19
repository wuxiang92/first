package com.will.first.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

@Configuration
public class RedisUnLockLuaScriptConfig {

    @Bean(value = "unlock")
    public DefaultRedisScript defaultRedisScript(){
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("script/unlock.lua")));
        redisScript.setResultType(Long.class);
        return redisScript;
    }

}
