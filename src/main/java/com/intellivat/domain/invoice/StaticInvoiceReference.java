package com.intellivat.domain.invoice;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A static implementation of {@link com.intellivat.domain.invoice.InvoiceReference}, which is used to implement
 * references within Java code. In the future there might be other sources of references.
 */
public class StaticInvoiceReference
    implements InvoiceReference {

    private String displayName;

    private String queryPath;

    private Class<?> type;

    @JsonCreator
    public StaticInvoiceReference( @JsonProperty( "displayName" ) String displayName ) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName( String displayName ) {
        this.displayName = displayName;
    }

    @Override
    public String getQueryPath() {
        return queryPath;
    }

    @Override
    public void setQueryPath( String queryPath ) {
        this.queryPath = queryPath;
    }

    @Override
    public String toString() {
        return "Reference Value: " + displayName;
    }

    @Override
    public Class<?> getType() {
        return type;
    }

    @Override
    public void setType( Class<?> type ) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        return prime * result + Objects.hash( displayName, queryPath, type );
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        StaticInvoiceReference other = (StaticInvoiceReference) obj;

        return Objects.equals( displayName, other.displayName )
            && Objects.equals( queryPath, other.queryPath )
            && Objects.equals( type, other.type );
    }

}
