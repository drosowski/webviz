package com.intellivat.domain.rules;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Parameters are used by the {@link DecisionRule} to define the name and the allowed values for a
 * {@link com.intellivat.domain.taxtree.SimpleDecisionNode#getParameterValues() parameterValue}.
 *
 * @author Daniel Rosowski
 */
@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
public class SelectParameter implements Parameter {

    private final String name;

    private String description;

    private List<ParameterValue> allowedValues = new ArrayList<>();

    @JsonCreator
    public SelectParameter(@JsonProperty("name") String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public List<ParameterValue> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues( List<ParameterValue> allowedValues ) {
        this.allowedValues = allowedValues;
    }

    public boolean isAllowedValue( ParameterValue value ) {
        if ( value == null ) {
            return false;
        }
        return allowedValues.contains(value);
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }

        final SelectParameter other = (SelectParameter) obj;
        return Objects.equals( this.name, other.getName() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.name);
    }
}
