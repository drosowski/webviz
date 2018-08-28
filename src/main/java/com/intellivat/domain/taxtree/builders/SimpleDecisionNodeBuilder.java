package com.intellivat.domain.taxtree.builders;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.google.common.base.Preconditions;
import com.intellivat.domain.rules.DecisionRule;
import com.intellivat.domain.rules.DecisionRuleRepository;
import com.intellivat.domain.rules.ParameterValue;
import com.intellivat.domain.rules.TextValue;
import com.intellivat.domain.taxtree.SimpleDecisionNode;

/**
 * Builder for {@link SimpleDecisionNode}. Use the {@link NodeFactory}!
 * 
 * @author Daniel Rosowski
 */
public class SimpleDecisionNodeBuilder<T extends SimpleDecisionNode>
    extends DecisionNodeBuilder<T> {

    private DecisionRuleRepository ruleRepository;

    public SimpleDecisionNodeBuilder( DecisionRuleRepository ruleRepository ) {
        this.ruleRepository = ruleRepository;
    }

    /**
     * @param ruleId
     * @param clazz
     * @return a new builder for the given {@code clazz} referencing the rule with the given {@code ruleId}.
     */
    public SimpleDecisionNodeBuilder<T> newDecisionNodeFromRule( String ruleId, Class<T> clazz ) {
        DecisionRule rule = ruleRepository.getRuleFor( ruleId );
        T instance = null;
        try {
            instance = clazz.getDeclaredConstructor( DecisionRule.class ).newInstance( rule );
        }
        catch ( InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                        | NoSuchMethodException | SecurityException e ) {
            throw new IllegalStateException( "Something went wrong initializing the builder!", e );
        }
        setInstance( instance );

        return this;
    }

    /**
     * Sets the {@link SimpleDecisionNode#getParameterValues() parameterValues} for the node.
     * 
     * @param values
     * @return the builder
     */
    public SimpleDecisionNodeBuilder<T> withParameterValues( ParameterValue... values ) {
        for ( ParameterValue value : values ) {
            getInstance().addParameterValue( value );
        }
        return this;
    }

    /**
     * Sets the {@link SimpleDecisionNode#getParameterValues() parameterValues} for the node.
     * 
     * @param values as strings, will be wrapped in a parameterValue class
     * @return the builder
     */
    public SimpleDecisionNodeBuilder<T> withParameterValues( String... values ) {
        for ( String value : values ) {
            Preconditions.checkNotNull( value, "A ParameterValue must never be null" );
            TextValue textValue = new TextValue( value );
            getInstance().addParameterValue(textValue);
        }
        return this;
    }

    /**
     * Sets the {@link SimpleDecisionNode#getParameterValues() parameterValues} for the node.
     * 
     * @param values
     * @return the builder
     */
    public SimpleDecisionNodeBuilder<T> withParameterValues( List<ParameterValue> values ) {
        for ( ParameterValue value : values ) {
            getInstance().addParameterValue( value );
        }
        return this;
    }
}