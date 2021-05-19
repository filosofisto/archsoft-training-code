package com.archsoft.mongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collections;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    RedisConnectionFactory lettuceConnectionFactory() {
//        List<String> nodes = Collections.singletonList("random-claro-id-ro.oozcd4.ng.0001.euc1.cache.amazonaws.com:6379");
        List<String> nodes = Collections.singletonList("random-claro-id-001.oozcd4.0001.euc1.cache.amazonaws.com:6379");
        RedisClusterConfiguration clusterConfiguration = new RedisClusterConfiguration(nodes);
//        clusterConfiguration.setUsername("randomicclaroid-user");
//        clusterConfiguration.setPassword(RedisPassword.of("EduardoRibeiroSilva"));
        return new LettuceConnectionFactory(clusterConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(lettuceConnectionFactory());
        return template;
    }
}
