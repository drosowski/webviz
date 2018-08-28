package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Masterdata is the common type of queryable objects in TDIS and defines a {@link #masterdataKey()} function to
 * retrieve a Masterdata specific key.
 */
@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
public interface Masterdata {

    String masterdataKey();

}
