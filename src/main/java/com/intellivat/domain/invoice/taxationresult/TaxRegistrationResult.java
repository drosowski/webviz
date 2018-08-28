package com.intellivat.domain.invoice.taxationresult;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.intellivat.domain.masterdata.TaxRegistration;

import java.util.Objects;
import java.util.Optional;

public class TaxRegistrationResult {

    private final TaxRegistration sellerTaxRegistration;

    private final TaxRegistration buyerTaxRegistration;

    @JsonCreator
    public TaxRegistrationResult( @JsonProperty( "sellerTaxRegistration" ) TaxRegistration sellerTaxRegistration,
                                  @JsonProperty( "buyerTaxRegistration" ) TaxRegistration buyerTaxRegistration ) {
        this.sellerTaxRegistration = sellerTaxRegistration;
        this.buyerTaxRegistration = buyerTaxRegistration;
    }

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
    public Optional<TaxRegistration> getSellerTaxRegistration() {
        return Optional.ofNullable( sellerTaxRegistration );
    }

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
    public Optional<TaxRegistration> getBuyerTaxRegistration() {
        return Optional.ofNullable( buyerTaxRegistration );
    }

    @Override
    public String toString() {
        return "TaxRegistrationResult{" +
                        "sellerTaxRegistration=" + sellerTaxRegistration +
                        ", buyerTaxRegistration=" + buyerTaxRegistration +
                        '}';
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        TaxRegistrationResult that = (TaxRegistrationResult) o;
        return Objects.equals( sellerTaxRegistration, that.sellerTaxRegistration ) &&
                        Objects.equals( buyerTaxRegistration, that.buyerTaxRegistration );
    }

    @Override
    public int hashCode() {
        return Objects.hash( sellerTaxRegistration, buyerTaxRegistration );
    }
}
