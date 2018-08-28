package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A tax rate used for the calculation of the actual tax amount.
 */
@ViewableFields( { "taxRateIndicator", "rateInPercent", "jurisdiction" } )
public class TaxRate implements Masterdata {

    private final TaxRateIndicator taxRateIndicator;

    private final Double rateInPercent;

    private final Jurisdiction jurisdiction;

    @JsonCreator
    public TaxRate(@JsonProperty("taxRateIndicator") TaxRateIndicator taxRateIndicator,
                   @JsonProperty("rateInPercent") Double rateInPercent,
                   @JsonProperty("jurisdiction") Jurisdiction jurisdiction) {
        this.taxRateIndicator = taxRateIndicator;
        this.rateInPercent = rateInPercent;
        this.jurisdiction = jurisdiction;
    }

    public TaxRateIndicator getTaxRateIndicator() {
        return taxRateIndicator;
    }

    public Double getRateInPercent() {
        return rateInPercent;
    }

    public Jurisdiction getJurisdiction() {
        return jurisdiction;
    }

    @Override
    public String toString() {
        return "TaxRate [taxRateIndicator=" + taxRateIndicator + ", rateInPercent=" + rateInPercent + ", jurisdiction="
            + jurisdiction + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxRate taxRate = (TaxRate) o;
        return Objects.equals(taxRateIndicator, taxRate.taxRateIndicator) &&
                Objects.equals(rateInPercent, taxRate.rateInPercent) &&
                Objects.equals(jurisdiction, taxRate.jurisdiction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxRateIndicator, rateInPercent, jurisdiction);
    }

    @Override
    public String masterdataKey() {
        return taxRateIndicator.masterdataKey() + "-" + jurisdiction.masterdataKey();
    }

}
