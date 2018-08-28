package com.intellivat.domain.rules;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

/**
 * Parameters are used by the {@link com.intellivat.domain.rules.DecisionRule} to define the name and the allowed values for a
 * {@link com.intellivat.domain.taxtree.SimpleDecisionNode#getParameterValues() parameterValue}.
 *
 * @author Daniel Rosowski
 */
@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
public class SimpleParameter implements Parameter {

    private final String name;

    private String description;

    @JsonCreator
    public SimpleParameter(@JsonProperty("name") String name) {
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


    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }

        final SimpleParameter other = (SimpleParameter) obj;
        return Objects.equals( this.name, other.getName() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.name);
    }

    @Override
    public String toString() {
        return "SimpleParameter{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
