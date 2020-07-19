package com.will.first.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
@Configuration
public class RedisConfig {

    @Bean(name = "redisTemplate")
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        log.info("RedisConfig init");
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

}
