package com.naluri.api.repository;

import com.naluri.api.model.PiState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PiRedisRepositoryTest {

    @Autowired
    private PiRedisRepository repository;

    @Test
    void testSetAndGetPiState() {

        // create a sample PiState
        PiState stateAction = new PiState();
        stateAction.setValueOfPi("3.146");
        stateAction.setIteration(10);
        stateAction.setLastUpdatedTimestamp(System.currentTimeMillis());

        // save to Redis
        repository.setPiState(stateAction);

        // retrieve data from Redis
        PiState retrievedDataFromRedis = repository.getPiState();

        //verify if data is successfully retrieved from Redis
        assertThat(retrievedDataFromRedis).isNotNull();
        assertThat(retrievedDataFromRedis.getValueOfPi()).isEqualTo("3.145");
        assertThat(retrievedDataFromRedis.getIteration()).isEqualTo(10);
        System.out.println("JSON here = " + retrievedDataFromRedis);
        System.out.println("Retrieved PiState from Redis");
        System.out.println("Pi State : value = " + retrievedDataFromRedis.getValueOfPi());
        System.out.println("Pi State : iteration = " + retrievedDataFromRedis.getIteration());
        System.out.println("Pi State : lastUpdateTimeStamp = " + retrievedDataFromRedis.getLastUpdatedTimestamp());
    }
}
