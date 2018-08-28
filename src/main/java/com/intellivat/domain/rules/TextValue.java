package com.intellivat.domain.rules;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A type of {@code parameterValue} that takes a fixed text string instead of a dynamic invoice field. "Fixed" means
 * that the string is being defined at design time in the Modeler and does not come from the actually processed invoice
 * like {@link com.intellivat.domain.invoice.InvoiceReference}s.
 * 
 * @author Daniel Rosowski
 */

public class TextValue
    implements ParameterValue {

    public static final TextValue EMPTY = new TextValue( "" );
    private final String value;

    @JsonCreator
    public TextValue( @JsonProperty( "value" ) String value ) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getDisplayName() {
        return value;
    }

    public void setDisplayName( String displayName ) {
        // do nothing, only needed for (de)-serialization
    }

    @Override
    @JsonIgnore
    public Class<?> getType() {
        return String.class;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }

        TextValue other = (TextValue) obj;

        return Objects.equals( this.value, other.value );
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.value );
    }

    @Override
    public String toString() {
        return "TextValue{" +
            "value='" + value + '\'' +
            '}';
    }
}
