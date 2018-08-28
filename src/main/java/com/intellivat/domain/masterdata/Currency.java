package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.RoundingMode;
import java.util.Objects;

/**
 * A currency and its' attributes.
 *
 * @author Alexander Niemann
 */
@ViewableFields( { "roundingMode", "fractionDigits" } )
public class Currency
    implements Masterdata {

    /**
     * ISO code, e.g. 'EUR' or 'CSD'.
     */
    private final String code;

    /**
     * Rounding method to use when calculating amounts of this currency, e.g. 'HALF_UP' for 'EUR'.
     */
    private final RoundingMode roundingMode;

    /**
     * Number of fraction digits to use for amounts of this currency, e.g. 2 for 'EUR'.
     */
    private final Integer fractionDigits;

    @JsonCreator
    public Currency( @JsonProperty( "code" ) String code,
                     @JsonProperty( "roundingMode" ) RoundingMode roundingMode,
                     @JsonProperty("fractionDigits") Integer fractionDigits) {
        this.code = code;
        this.roundingMode = roundingMode;
        this.fractionDigits = fractionDigits;
    }

    public RoundingMode getRoundingMode() {
        return roundingMode;
    }

    public Integer getFractionDigits() {
        return fractionDigits;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Currency{" +
            "code='" + code + '\'' +
            ", roundingMode=" + roundingMode +
            ", fractionDigits=" + fractionDigits +
            '}';
    }

    @Override
    public String masterdataKey() {
        return code;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Currency currency = (Currency) o;
        return Objects.equals( fractionDigits, currency.fractionDigits ) &&
            Objects.equals( code, currency.code ) &&
            Objects.equals( roundingMode, currency.roundingMode );
    }

    @Override
    public int hashCode() {
        return Objects.hash( code, roundingMode, fractionDigits );
    }

}
