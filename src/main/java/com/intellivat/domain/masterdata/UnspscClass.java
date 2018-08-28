package com.intellivat.domain.masterdata;

/**
 * Defines the allowed main classes of an {@link com.intellivat.domain.masterdata.UnspscClassification}, i.e. if it is
 * Material or Service.
 *
 * @author Alexander Niemann
 */
public enum UnspscClass {

    MATERIAL( "Material" ),
    SERVICE( "Service" );

    private final String name;

    UnspscClass( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
