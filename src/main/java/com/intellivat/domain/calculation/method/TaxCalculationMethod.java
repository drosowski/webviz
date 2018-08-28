package com.intellivat.domain.calculation.method;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

/**
 * The calculation method that gets applied for a given {@link com.intellivat.domain.masterdata.TaxType} and
 * {@link import com.intellivat.domain.masterdata.TaxIndicator}.
 */
public enum TaxCalculationMethod {

    RATE( "Rate", null, new RonaCalculation() ),
    ZERO( "Fixed Tax Amount of 0", "Z", new ZeroCalculation() ),
    NOTHING( "No Tax Calculation", null, new ZeroCalculation() ),
    ERROR( "Error", null, new ZeroCalculation() );

    private static final List<TaxCalculationMethod> NOOP_CALCULATION_METHODS = Lists.newArrayList( TaxCalculationMethod.ERROR,
            TaxCalculationMethod.NOTHING );

    private final String fullName;

    private final CalculationMethod calculationMethod;

    private final Optional<String> replacementTaxRateIndicator;

    private TaxCalculationMethod( String fullName, String replacementTaxRateIndicator, CalculationMethod calculationMethod ) {
        this.fullName = fullName;
        this.calculationMethod = calculationMethod;
        this.replacementTaxRateIndicator = Optional.ofNullable( replacementTaxRateIndicator );
    }

    public String getFullName() {
        return fullName;
    }

    /**
     * A tax calculation method can define a replacement for the tax rate indicator. For example if there's an article
     * with a standard tax rate indicator ('A'), but the invoice line yields a ZERO tax calculation method, we need to
     * replace the tax rate indicator with 'Z'.
     * <p></p>
     * The replacement is optional, so if it yields Optional.absent() no replacement is necessary.
     *
     * @return
     */
    public Optional<String> getReplacementTaxRateIndicator() {
        return replacementTaxRateIndicator;
    }

    /**
     * Checks whether this method is a No-Operation method. A noop method does not trigger any calculation of the tax
     * amount.
     *
     * @return
     */
    public boolean isNoop() {
        return NOOP_CALCULATION_METHODS.contains( this );
    }

    public CalculationMethod getCalculationMethod() {
        return calculationMethod;
    }
}
