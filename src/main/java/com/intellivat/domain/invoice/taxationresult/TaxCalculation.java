package com.intellivat.domain.invoice.taxationresult;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import com.intellivat.domain.Amount;
import com.intellivat.domain.masterdata.TaxRate;
import com.intellivat.domain.masterdata.TaxRateIndicator;

import java.math.BigDecimal;
import java.util.Objects;

public class TaxCalculation {

    private final Amount baseAmount;
    private final TaxRate taxRate;
    private final Amount taxAmount;
    private final Amount totalAmount;

    @JsonCreator
    public TaxCalculation(@JsonProperty("baseAmount") Amount baseAmount,
                          @JsonProperty("taxRate") TaxRate taxRate,
                          @JsonProperty("taxAmount") Amount taxAmount,
                          @JsonProperty("totalAmount") Amount totalAmount) {
        this.baseAmount = baseAmount;
        this.taxRate = taxRate;
        this.taxAmount = taxAmount;
        this.totalAmount = totalAmount;
    }

    public TaxCalculation(Amount baseAmount,
                          TaxRate taxRate,
                          Amount taxAmount) {
        this.baseAmount = baseAmount;
        this.taxRate = taxRate;
        this.taxAmount = taxAmount;
        this.totalAmount = baseAmount.add(taxAmount);
    }

    public Amount getBaseAmount() {
        return baseAmount;
    }

    public TaxRate getTaxRate() {
        return taxRate;
    }

    @JsonIgnore
    public TaxRateIndicator getTaxRateIndicator() {
        return taxRate.getTaxRateIndicator();
    }

    public Amount getTaxAmount() {
        return taxAmount;
    }

    public Amount getTotalAmount() {
        return totalAmount;
    }

    @JsonIgnore
    public BigDecimal getTaxRateInPercent() {
        return BigDecimal.valueOf(taxRate.getRateInPercent());
    }

    public TaxCalculation add(TaxCalculation other){
        Preconditions.checkArgument(taxRate.equals(other.taxRate), "TaxCalculations with different TaxRates can not be added");
        return new TaxCalculation(
                baseAmount.add(other.baseAmount),
                taxRate,
                taxAmount.add(other.taxAmount),
                totalAmount.add(other.totalAmount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxCalculation that = (TaxCalculation) o;
        return Objects.equals(baseAmount, that.baseAmount) &&
                Objects.equals(taxRate, that.taxRate) &&
                Objects.equals(taxAmount, that.taxAmount) &&
                Objects.equals(totalAmount, that.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseAmount, taxRate, taxAmount, totalAmount);
    }
}
