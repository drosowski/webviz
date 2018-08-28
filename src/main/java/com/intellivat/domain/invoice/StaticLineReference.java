package com.intellivat.domain.invoice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StaticLineReference
    extends StaticInvoiceReference
    implements LineReference {

    @JsonCreator
    public StaticLineReference(@JsonProperty( "displayName" ) String displayName ) {
        super(displayName );
    }
}
