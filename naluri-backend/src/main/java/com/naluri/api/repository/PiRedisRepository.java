package com.naluri.api.repository;

import com.naluri.api.model.PiState;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

// INFO - checking the value inside Redis using terminal
// 1. Make sure run the docker desktop
// 2. Run terminal and type docker ps to check the container id
// 3. Type docker exec -it <container_id> redis-cli then now you have entered the redis terminal

@Repository
public class PiRedisRepository {

    //declare the key as final constant to avoid need to retype the key anywhere and becomes typo
    private static final String PI_STATE_KEY = "pi:state";

    private final RedisTemplate<String, PiState> redisTemplate;

    public PiRedisRepository(RedisTemplate<String, PiState> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // get the PiState
    public PiState getPiState() {
        return redisTemplate.opsForValue().get(PI_STATE_KEY);
    }

    // set the PiState
    public void setPiState(PiState piState) {
        redisTemplate.opsForValue().set(PI_STATE_KEY, piState);
    }

}
