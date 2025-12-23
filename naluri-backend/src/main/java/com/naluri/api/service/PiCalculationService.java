package com.naluri.api.service;

import com.naluri.api.model.PiState;
import com.naluri.api.repository.PiRedisRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PiCalculationService {

    private final PiRedisRepository repository;
    private final PiFormula formula;

    public PiCalculationService(PiRedisRepository repository, PiFormula formula){
        this.repository = repository;
        this.formula = formula;
    }

    public void calculateNextPi() {
        PiState current = getOrInitializePiState();

        System.out.println("----------------------------------------");
        System.out.println("currentPi = " + current.getValueOfPi());
        System.out.println("iteration = " + current.getIteration());
        System.out.println("update Time Stamp = " + current.getLastUpdatedTimestamp());
        System.out.println("----------------------------------------");

        long nextIteration = current.getIteration() + 1;

        double currentPi = Double.parseDouble(current.getValueOfPi());

        BigDecimal nextPi = formula.usingNilakanthaFormula(BigDecimal.valueOf(currentPi), current.getIteration());

        PiState nextState = new PiState();

        nextState.setValueOfPi(String.valueOf(nextPi));
        nextState.setIteration(nextIteration);
        nextState.setLastUpdatedTimestamp(System.currentTimeMillis());

        repository.setPiState(nextState);
    }


    public PiState getOrInitializePiState() {
        PiState state = repository.getPiState();

        if (state == null || state.getValueOfPi() == null) {
            state = new PiState();
            state.setValueOfPi(String.valueOf(formula.getInitialValue()));
            state.setIteration(0);
            state.setLastUpdatedTimestamp(System.currentTimeMillis());

            repository.setPiState(state);
        }

        return state;
    }
}
