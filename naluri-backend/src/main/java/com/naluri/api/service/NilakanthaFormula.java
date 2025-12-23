package com.naluri.api.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class NilakanthaFormula implements PiFormula {
    // keep 50 significant digits
    // next digit ≥ 5 → round up; else round down.
    private static final MathContext piPrecision = new MathContext(50, RoundingMode.HALF_UP);

    @Override
    public BigDecimal getInitialValue() {
        return BigDecimal.valueOf(3);
    }

    @Override
    public BigDecimal usingNilakanthaFormula(BigDecimal currentValue, long iteration) {
        long counter = iteration + 1;

//        double term = 4.0 / ((2.0 * counter) * (2.0 * counter + 1) * (2.0 * counter + 2));
        BigDecimal firstTerm = BigDecimal.valueOf(2L * counter);
        BigDecimal secondTerm = BigDecimal.valueOf(2L * counter + 1);
        BigDecimal thirdTerm = BigDecimal.valueOf(2L * counter + 2);

        BigDecimal termCombination = firstTerm.multiply(secondTerm.multiply(thirdTerm));



        BigDecimal finalTerm = BigDecimal.valueOf(4).divide(termCombination, piPrecision);


        if (counter % 2 == 0) {
            return currentValue.subtract(finalTerm);
        } else {
            return currentValue.add(finalTerm);
        }
    }

}
