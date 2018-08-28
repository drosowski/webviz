package com.intellivat.domain.rules;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This interface defines implementing classes as a valid value that can be used in
 * {@link com.intellivat.domain.taxtree.SimpleDecisionNode#addParameterValue(ParameterValue)}
 * or as an {@link SelectParameter#getAllowedValues()
 * allowed value}.
 *
 * @author Daniel Rosowski
 */
@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
public interface ParameterValue {

    /**
     * Gives the value's string representation to be used for decision node rendering in the Modeler.
     *
     * @return
     */
    String getDisplayName();

    Class<?> getType();
}
