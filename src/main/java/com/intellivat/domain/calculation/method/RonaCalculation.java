package com.intellivat.domain.calculation.method;

import com.intellivat.domain.Amount;

/**
 * Implements the calculation method defined in {@link TaxCalculationMethod#RATE}.
 *
 * @author Daniel Rosowski
 */
public class RonaCalculation
        implements CalculationMethod {

    private static final int HUNDRED_PERCENT = 100;

    @Override
    public Amount calculateTaxAmountFromNet( Amount baseAmount, double taxRate ) {
        Amount taxRateAmount = Amount.valueOf( taxRate ).divide( Amount.valueOf( HUNDRED_PERCENT ) );
        return baseAmount.multiply( taxRateAmount );
    }

    @Override
    public Amount calculateTaxAmountFromGrossFix( Amount baseAmount, double taxRate ) {
        Amount taxRateAmount = Amount.valueOf( taxRate ).divide( Amount.valueOf( HUNDRED_PERCENT ) );
        return baseAmount.divide( taxRateAmount.add( Amount.ONE ) ).multiply( taxRateAmount );
    }
}
