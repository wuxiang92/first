package com.will.first.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Slf4j
@Configuration
public class CacheConfig {

    @Bean("userInfoCache")
    public CacheManager cacheManager(){
        log.info("userInfoCache init");
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterAccess(Duration.ofMinutes(1))
                .initialCapacity(100)
                .maximumSize(300)

        );
        return caffeineCacheManager;
    }

}
