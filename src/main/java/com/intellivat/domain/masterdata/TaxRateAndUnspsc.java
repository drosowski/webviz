package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxRateAndUnspsc {

    private final TaxRate taxRate;
    private final Unspsc unspsc;

    @JsonCreator
    public TaxRateAndUnspsc(@JsonProperty("taxRate") TaxRate taxRate,
                            @JsonProperty("unspsc") Unspsc unspsc) {
        this.taxRate = taxRate;
        this.unspsc = unspsc;
    }

    public TaxRate getTaxRate() {
        return taxRate;
    }

    public Unspsc getUnspsc() {
        return unspsc;
    }

}
