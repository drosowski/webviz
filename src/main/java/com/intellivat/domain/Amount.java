package com.intellivat.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A common type to handle different amounts within the calculation process.
 *
 * @author Alex Rommel
 */
//TODO: refactor to better package?
public final class Amount {

    private final static int MAX_SCALE = 6;

    private final static RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    public final static Amount ZERO = Amount.valueOf( BigDecimal.ZERO );

    public final static Amount ONE = Amount.valueOf( BigDecimal.ONE );

    private final BigDecimal value;

    private Amount( double value ) {
        this.value = BigDecimal.valueOf( value );
    }

    private Amount( long value ) {
        this.value = BigDecimal.valueOf( value );
    }

    private Amount( Amount amount ) {
        this.value = amount.value;
    }

    private Amount( BigDecimal value ) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @JsonCreator
    public static Amount valueOf( @JsonProperty( "value" ) BigDecimal value ) {
        return new Amount( value );
    }

    public static Amount valueOf( double value ) {
        return new Amount( value );
    }

    public static Amount valueOf( long value ) {
        return new Amount( value );
    }

    public static Amount valueOf( String value ) {
        return new Amount( new BigDecimal( value ) );
    }

    public static Amount copyOf( Amount amount ) {
        return new Amount( amount );
    }

    public Amount add( Amount augend ) {
        return new Amount( value.add( augend.getValue() ) );
    }

    public Amount subtract(Amount augend) {
        return new Amount(value.subtract(augend.getValue()));
    }

    public Amount multiply( Amount factor ) {
        return new Amount( value.multiply( factor.value ) );
    }

    public Amount divide( Amount divisor ) {
        return Amount.valueOf( value.divide( divisor.getValue(), MAX_SCALE, ROUNDING_MODE ) );
    }

    public Amount setScale( int newScale, RoundingMode roundingMode ) {
        return Amount.valueOf( value.setScale( newScale, roundingMode ) );
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * Compares this Amount with the specified Amount. Two Amount objects that are equal in value but have a different
     * scale (like 2.0 and 2.00) are considered equal by this method.
     */
    @Override
    public boolean equals( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        Amount other = (Amount) obj;
        return value.compareTo( other.value ) == 0;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
