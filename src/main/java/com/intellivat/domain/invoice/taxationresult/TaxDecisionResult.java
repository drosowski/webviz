package com.intellivat.domain.invoice.taxationresult;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.intellivat.domain.masterdata.Jurisdiction;
import com.intellivat.domain.masterdata.TaxIndicator;

import java.util.Objects;
import java.util.Optional;

@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
public class TaxDecisionResult {

    private final TaxIndicator taxIndicator;

    private final Jurisdiction sellerJurisdiction;

    private final Jurisdiction sellerTaxRegJurisdiction;

    private final Jurisdiction buyerJurisdiction;

    private final Jurisdiction buyerTaxRegJurisdiction;

    @JsonCreator
    public TaxDecisionResult( @JsonProperty( "taxIndicator" ) TaxIndicator taxIndicator,
                              @JsonProperty( "sellerJurisdiction" ) Jurisdiction sellerJurisdiction,
                              @JsonProperty( "buyerJurisdiction" ) Jurisdiction buyerJurisdiction,
                              @JsonProperty( "sellerTaxRegJurisdiction" ) Jurisdiction sellerTaxRegJurisdiction,
                              @JsonProperty( "buyerTaxRegJurisdiction" ) Jurisdiction buyerTaxRegJurisdiction ) {
        this.taxIndicator = taxIndicator;
        this.sellerJurisdiction = sellerJurisdiction;
        this.buyerJurisdiction = buyerJurisdiction;
        this.sellerTaxRegJurisdiction = sellerTaxRegJurisdiction;
        this.buyerTaxRegJurisdiction = buyerTaxRegJurisdiction;
    }

    /**
     * This constructor can be used if the buyerJurisdiction is the same as the sellerJurisdiction.
     */
    public TaxDecisionResult( TaxIndicator taxIndicator, Jurisdiction sellerJurisdiction ) {
        this( taxIndicator, sellerJurisdiction, sellerJurisdiction, sellerJurisdiction, sellerJurisdiction );
    }

    public TaxIndicator getTaxIndicator() {
        return taxIndicator;
    }

    public Jurisdiction getSellerJurisdiction() {
        return sellerJurisdiction;
    }

    public Jurisdiction getBuyerJurisdiction() {
        return buyerJurisdiction;
    }

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
    public Optional<Jurisdiction> getSellerTaxRegJurisdiction() {
        return Optional.ofNullable( sellerTaxRegJurisdiction );
    }

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
    public Optional<Jurisdiction> getBuyerTaxRegJurisdiction() {
        return Optional.ofNullable( buyerTaxRegJurisdiction );
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        TaxDecisionResult that = (TaxDecisionResult) o;
        return Objects.equals( taxIndicator, that.taxIndicator ) &&
                        Objects.equals( sellerJurisdiction, that.sellerJurisdiction ) &&
                        Objects.equals( sellerTaxRegJurisdiction, that.sellerTaxRegJurisdiction ) &&
                        Objects.equals( buyerJurisdiction, that.buyerJurisdiction ) &&
                        Objects.equals( buyerTaxRegJurisdiction, that.buyerTaxRegJurisdiction );
    }

    @Override
    public int hashCode() {
        return Objects.hash( taxIndicator, sellerJurisdiction, sellerTaxRegJurisdiction, buyerJurisdiction, buyerTaxRegJurisdiction );
    }
}
