package com.naluri.api.model;

public class PiState {

    private String valueOfPi;
    private long iteration;
    private long lastUpdatedTimestamp;

    // getter and setter for valueOfPi
    public String getValueOfPi() {
        return valueOfPi;
    }
    public void setValueOfPi(String valueOfPi) {
        this.valueOfPi = valueOfPi;
    }
    // ------------------------------



    // getter and setter for iteration
    public long getIteration() {
        return iteration;
    }
    public void setIteration(long iteration) {
        this.iteration = iteration;
    }
    // ------------------------------



    // getter and setter for lastUpdatedTimestamp
    public long getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }
    public void setLastUpdatedTimestamp(long lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }
    // ------------------------------


}
