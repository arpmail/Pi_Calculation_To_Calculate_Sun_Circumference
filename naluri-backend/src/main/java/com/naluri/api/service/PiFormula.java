package com.naluri.api.service;

import java.math.BigDecimal;

public interface PiFormula {

    // Initial value of π before any iteration.
    BigDecimal getInitialValue();

    // Calculate next π value based on current state.
    BigDecimal usingNilakanthaFormula(BigDecimal currentValue, long iteration);

}
