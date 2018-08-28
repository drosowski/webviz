package com.intellivat.domain.invoice.taxationresult;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intellivat.domain.Amount;
import com.intellivat.domain.invoice.enriched.EnrichedLine;
import com.intellivat.domain.masterdata.LocationLevel;
import com.intellivat.domain.taxtree.EvaluationSteps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class InvoiceLine {

    private final EnrichedLine enrichedLine;

    private final EvaluationSteps steps;

    private final Map<LocationLevel, TaxCalculationForTaxDecisionResult> taxCalculations;

    @JsonCreator
    public InvoiceLine(@JsonProperty("enrichedLine") EnrichedLine enrichedLine,
                       @JsonProperty("steps") EvaluationSteps steps,
                       @JsonProperty("taxCalculations") Map<LocationLevel, TaxCalculationForTaxDecisionResult> taxCalculations) {
        this.enrichedLine = enrichedLine;
        this.taxCalculations = taxCalculations;
        this.steps = steps;
    }

    public EnrichedLine getEnrichedLine() {
        return enrichedLine;
    }

    public Map<LocationLevel, TaxCalculationForTaxDecisionResult> getTaxCalculations() {
        return taxCalculations;
    }

    public EvaluationSteps getSteps() {
        return steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceLine that = (InvoiceLine) o;
        return Objects.equals(enrichedLine, that.enrichedLine) &&
                Objects.equals(taxCalculations, that.taxCalculations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrichedLine, taxCalculations);
    }

    @JsonIgnore
    public TotalCalculation getLineTotal() {
        Amount baseAmount = taxCalculations.values().iterator().next().getTaxCalculation().getBaseAmount();
        Amount taxTotal = taxCalculations.values().stream()
                .map(taxCalculation -> taxCalculation.getTaxCalculation().getTaxAmount())
                .reduce(Amount::add)
                .get();
        return new TotalCalculation( baseAmount, taxTotal, baseAmount.add(taxTotal));
    }

}


