package com.intellivat.domain.calculation.method;

import com.intellivat.domain.Amount;

/**
 * The most simplistic {@code taxCalculation} that always returns 0 (zero) as {@code taxAmount}.
 *
 * @author Daniel Rosowski
 */
public class ZeroCalculation
        implements CalculationMethod {

    @Override
    public Amount calculateTaxAmountFromNet( Amount baseAmount, double taxRate ) {
        return Amount.ZERO;
    }

    @Override
    public Amount calculateTaxAmountFromGrossFix( Amount baseAmount, double taxRate ) {
        return Amount.ZERO;
    }
}
