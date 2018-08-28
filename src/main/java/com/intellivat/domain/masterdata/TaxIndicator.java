package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intellivat.domain.calculation.method.TaxCalculationMethod;

import java.util.Objects;

/**
 * The tax indicator is a flag in the {@link com.intellivat.domain.invoice.taxationresult.TaxDecisionResult} that defines the {@link TaxCalculationMethod} to be used for
 * the line of an invoice.
 *
 * @author Daniel Rosowski
 */
@ViewableFields( { "name", "sellerMethod", "buyerMethod" } )
public class TaxIndicator implements Masterdata{

    private final String key;

    private final String name;

    private final TaxCalculationMethod sellerMethod;

    private final TaxCalculationMethod buyerMethod;

    @JsonCreator
    public TaxIndicator(@JsonProperty("key") String key,
                        @JsonProperty("name") String name,
                        @JsonProperty("sellerMethod") TaxCalculationMethod sellerMethod,
                        @JsonProperty("buyerMethod") TaxCalculationMethod buyerMethod) {
        this.key = key;
        this.name = name;
        this.sellerMethod = sellerMethod;
        this.buyerMethod = buyerMethod;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public TaxCalculationMethod getSellerMethod() {
        return sellerMethod;
    }

    public TaxCalculationMethod getBuyerMethod() {
        return buyerMethod;
    }

    @Override
    public String toString() {
        return this.getKey();
    }

    @Override
    public String masterdataKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxIndicator that = (TaxIndicator) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sellerMethod, that.sellerMethod) &&
                Objects.equals(buyerMethod, that.buyerMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, sellerMethod, buyerMethod);
    }
}
