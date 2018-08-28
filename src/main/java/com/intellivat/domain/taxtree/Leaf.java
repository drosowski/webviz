package com.intellivat.domain.taxtree;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Marks an endpoint in the {@link TaxDecisionTree}.
 * 
 * @author Daniel Rosowski
 */
@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
@JsonSubTypes( { @JsonSubTypes.Type( value = ResultNode.class ),
    @JsonSubTypes.Type( value = ExceptionNode.class ) } )
public interface Leaf {

    /**
     * Checks whether the data of this leaf is equal to that of the {@code other}.
     * 
     * @param other
     * @return
     */
    boolean dataEquals( Leaf other );
}
