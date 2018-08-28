package com.intellivat.domain.calculation.method;

import com.intellivat.domain.Amount;

/**
 * An interface that defines the concrete implementation for a {@link TaxCalculationMethod}. The calculation ca be
 * applied on different levels (e.g. line, group).
 *
 * @author Daniel Rosowski
 */
public interface CalculationMethod {

    /**
     * Calculates the tax amount for a given base amount and {@code taxRate}.
     * This is a net calculation so the base amount is a net amount.
     *
     * @param netAmount
     * @param taxRate
     * @return the {@code taxAmount}
     */
    Amount calculateTaxAmountFromNet( Amount netAmount, double taxRate );

    /**
     * Calculates the tax amount for a given base amount and {@code taxRate}.
     * This is a gross fix calculation so the base amount is a gross amount.
     * The result is the tax amount that is allready included in the given amount
     * for the given tax rate.
     *
     * @param grossAmount
     * @param taxRate
     * @return the {@code taxAmount}
     */
    Amount calculateTaxAmountFromGrossFix( Amount grossAmount, double taxRate );
}
