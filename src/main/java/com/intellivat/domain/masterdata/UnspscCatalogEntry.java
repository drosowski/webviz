package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Connects an {@link Unspsc} to a {@link TaxRateIndicator} in a {@link Jurisdiction } - for now. In the future the
 * catalog entry will cover a lot more attributes.
 */
@ViewableFields( { "unspsc", "taxRateIndicator", "jurisdiction" } )
public class UnspscCatalogEntry implements Masterdata{

    private final Unspsc unspsc;

    private final TaxRateIndicator taxRateIndicator;

    private final Jurisdiction jurisdiction;

    @JsonCreator
    public UnspscCatalogEntry(@JsonProperty("unspsc") Unspsc unspsc,
                              @JsonProperty("taxRateIndicator") TaxRateIndicator taxRateIndicator,
                              @JsonProperty("jurisdiction") Jurisdiction jurisdiction) {
        this.unspsc = unspsc;
        this.taxRateIndicator = taxRateIndicator;
        this.jurisdiction = jurisdiction;
    }

    public Unspsc getUnspsc() {
        return unspsc;
    }

    public TaxRateIndicator getTaxRateIndicator() {
        return taxRateIndicator;
    }

    public Jurisdiction getJurisdiction() {
        return jurisdiction;
    }

    @Override
    public String toString() {
        return "UnspscCatalogEntry{" +
                "unspsc=" + unspsc.getCode() +
                ", taxRateIndicator=" + taxRateIndicator.getKey() +
                ", jurisdiction=" + jurisdiction.masterdataKey() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnspscCatalogEntry that = (UnspscCatalogEntry) o;
        return Objects.equals(unspsc, that.unspsc) &&
                Objects.equals(taxRateIndicator, that.taxRateIndicator) &&
                Objects.equals(jurisdiction, that.jurisdiction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unspsc, taxRateIndicator, jurisdiction);
    }

    @Override
    public String masterdataKey() {
        return unspsc.masterdataKey() + '-' + taxRateIndicator.masterdataKey() + '-' + jurisdiction.masterdataKey();
    }

}
