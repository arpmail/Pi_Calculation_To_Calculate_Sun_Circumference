package com.naluri.api.config;

import com.naluri.api.model.PiState;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

// Start the redis inside docker
// 1. Open terminal inside here
// 2. docker run -d --name redis -p 6379:6379 redis:7
// 3. -d(run in background) | --name redis(container name) | -p 6379:6379(expose Redis to localhost) | redis:7(Redis image version inside docker)

@Configuration // this class is a configuration class, like a replacement for XML config.
public class RedisConfig {

    // Create an object of this type (RedisTemplate<String, PiState>) and manage it as a Spring bean
    @Bean
    public RedisTemplate<String, PiState> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, PiState> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);  // connect to Redis

        template.setKeySerializer(RedisSerializer.string()); // set the key as string

        // value PiState as JSON
        template.setValueSerializer(RedisSerializer.json()); // set the value to be put under the key as JSON

        template.afterPropertiesSet();
        return template;
    }


}
