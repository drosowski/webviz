package com.intellivat.domain.taxtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intellivat.domain.rules.DecisionRule;
import com.intellivat.domain.rules.ParameterValue;

/**
 * The simple decision node references only one yes node and one no node. It contains a list of
 * {@link #getParameterValues() parameterValues} that are used to evaluate the logic inside the {@link DecisionRule}.
 *
 * @author Daniel Rosowski
 */
public class SimpleDecisionNode
    extends DecisionNode {

    private DecisionRule decisionRule;

    @JsonProperty
    private List<ParameterValue> parameterValues = new ArrayList<>();

    public SimpleDecisionNode( DecisionRule decisionRule ) {
        this.decisionRule = decisionRule;
    }

    @JsonCreator
    public SimpleDecisionNode( @JsonProperty( "id" ) String id,
                               @JsonProperty( "decisionRule" ) DecisionRule decisionRule ) {
        super( id );
        this.decisionRule = decisionRule;
    }

    public List<ParameterValue> getParameterValues() {
        return Collections.unmodifiableList( parameterValues );
    }

    public void setParameterValues( List<ParameterValue> parameterValues ) {
        this.parameterValues = parameterValues;
    }

    @JsonIgnore
    public void setParameterValues( ParameterValue... values ) {
        parameterValues = new ArrayList<>();
        for ( ParameterValue value : values ) {
            addParameterValue( value );
        }
    }

    public void addParameterValue( ParameterValue value ) {
        this.parameterValues.add( value );
    }

    public void setDecisionRule( DecisionRule decisionRule ) {
        this.decisionRule = decisionRule;
    }

    public DecisionRule getDecisionRule() {
        return decisionRule;
    }
}
