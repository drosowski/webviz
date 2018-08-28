package com.intellivat.domain.taxtree;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.base.Preconditions;
import com.intellivat.domain.masterdata.Location;
import com.intellivat.domain.masterdata.MasterdataReference;
import com.intellivat.domain.masterdata.TaxIndicator;
import com.intellivat.domain.rules.ParameterValue;

import java.util.Objects;
import java.util.Optional;

public class Result {
    public static final String PARAMETER_VALUE_FOR_LOCATION_IS_NO_LOCATION_REPRESENTATION =
            "ParameterValue is no Location representation";
    private final MasterdataReference taxIndicatorReference;

    private final ParameterValue sellerJurisdictionReferenceLocation;

    @JsonProperty
    private final ParameterValue sellerTaxRegJurisdiction;

    private final ParameterValue buyerJurisdictionReferenceLocation;

    @JsonProperty
    private final ParameterValue buyerTaxRegJurisdiction;

    public Result( MasterdataReference taxIndicatorReference,
                   ParameterValue sellerJurisdictionReferenceLocation,
                   ParameterValue buyerJurisdictionReferenceLocation ) {
        this( taxIndicatorReference, sellerJurisdictionReferenceLocation, buyerJurisdictionReferenceLocation,
                        sellerJurisdictionReferenceLocation, buyerJurisdictionReferenceLocation );
    }

    @JsonCreator
    public Result( @JsonProperty( "taxIndicatorReference" ) MasterdataReference taxIndicatorReference,
                   @JsonProperty( "sellerJurisdictionReferenceLocation" ) ParameterValue sellerJurisdictionReferenceLocation,
                   @JsonProperty( "buyerJurisdictionReferenceLocation" ) ParameterValue buyerJurisdictionReferenceLocation,
                   @JsonProperty( "sellerTaxRegJurisdiction" ) ParameterValue sellerTaxRegJurisdiction,
                   @JsonProperty( "buyerTaxRegJurisdiction" ) ParameterValue buyerTaxRegJurisdiction ) {
        Preconditions.checkArgument(TaxIndicator.class.isAssignableFrom(taxIndicatorReference.getType()),
                "MasterdataReference for taxindicator is of wrong type: " + taxIndicatorReference.getType());
        Preconditions.checkNotNull( sellerJurisdictionReferenceLocation.getType() );
        Preconditions.checkNotNull( buyerJurisdictionReferenceLocation.getType() );
        Preconditions.checkArgument( Location.class.isAssignableFrom( sellerJurisdictionReferenceLocation.getType() ),
                        PARAMETER_VALUE_FOR_LOCATION_IS_NO_LOCATION_REPRESENTATION );
        Preconditions.checkArgument( Location.class.isAssignableFrom( buyerJurisdictionReferenceLocation.getType() ),
                        PARAMETER_VALUE_FOR_LOCATION_IS_NO_LOCATION_REPRESENTATION );
        this.taxIndicatorReference = taxIndicatorReference;
        this.sellerJurisdictionReferenceLocation = sellerJurisdictionReferenceLocation;
        this.buyerJurisdictionReferenceLocation = buyerJurisdictionReferenceLocation;
        this.sellerTaxRegJurisdiction = sellerTaxRegJurisdiction;
        this.buyerTaxRegJurisdiction = buyerTaxRegJurisdiction;
    }

    public MasterdataReference getTaxIndicatorReference() {
        return taxIndicatorReference;
    }

    public ParameterValue getSellerJurisdictionReferenceLocation() {
        return sellerJurisdictionReferenceLocation;
    }

    public ParameterValue getBuyerJurisdictionReferenceLocation() {
        return buyerJurisdictionReferenceLocation;
    }

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
    public Optional<ParameterValue> getSellerTaxRegJurisdiction() {
        return Optional.ofNullable( sellerTaxRegJurisdiction );
    }

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
    public Optional<ParameterValue> getBuyerTaxRegJurisdiction() {
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
        Result result = (Result) o;
        return Objects.equals( taxIndicatorReference, result.taxIndicatorReference ) &&
                        Objects.equals( sellerJurisdictionReferenceLocation, result.sellerJurisdictionReferenceLocation ) &&
                        Objects.equals( sellerTaxRegJurisdiction, result.sellerTaxRegJurisdiction ) &&
                        Objects.equals( buyerJurisdictionReferenceLocation, result.buyerJurisdictionReferenceLocation ) &&
                        Objects.equals( buyerTaxRegJurisdiction, result.buyerTaxRegJurisdiction );
    }

    @Override
    public int hashCode() {
        return Objects.hash( taxIndicatorReference, sellerJurisdictionReferenceLocation, sellerTaxRegJurisdiction,
                        buyerJurisdictionReferenceLocation, buyerTaxRegJurisdiction );
    }

    @Override
    public String toString() {
        return "Result{" +
                        "taxIndicatorReference=" + taxIndicatorReference +
                        ", sellerJurisdictionReferenceLocation=" + sellerJurisdictionReferenceLocation +
                        ", sellerTaxRegJurisdiction=" + sellerTaxRegJurisdiction +
                        ", buyerJurisdictionReferenceLocation=" + buyerJurisdictionReferenceLocation +
                        ", buyerTaxRegJurisdiction=" + buyerTaxRegJurisdiction +
                        '}';
    }
}
