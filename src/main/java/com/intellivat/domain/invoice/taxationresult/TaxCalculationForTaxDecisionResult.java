package com.intellivat.domain.invoice.taxationresult;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intellivat.domain.masterdata.Unspsc;

import java.util.Objects;

public class TaxCalculationForTaxDecisionResult {

    private final TaxCalculation taxCalculation;
    private final TaxDecisionResult taxDecisionResult;
    private final Unspsc unspsc;

    @JsonCreator
    public TaxCalculationForTaxDecisionResult(
            @JsonProperty("taxDecisionResult") TaxDecisionResult taxDecisionResult,
            @JsonProperty("taxCalculation") TaxCalculation taxCalculation,
            @JsonProperty("unspsc") Unspsc unspsc) {
        this.taxCalculation = taxCalculation;
        this.taxDecisionResult = taxDecisionResult;
        this.unspsc = unspsc;
    }

    public TaxCalculation getTaxCalculation() {
        return taxCalculation;
    }

    public TaxDecisionResult getTaxDecisionResult() {
        return taxDecisionResult;
    }

    public Unspsc getUnspsc() {
        return unspsc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxCalculationForTaxDecisionResult that = (TaxCalculationForTaxDecisionResult) o;
        return Objects.equals(taxCalculation, that.taxCalculation) &&
                Objects.equals(taxDecisionResult, that.taxDecisionResult) &&
                Objects.equals(unspsc, that.unspsc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxCalculation, taxDecisionResult, unspsc);
    }
}
