package com.intellivat.domain.rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A decision rule is a piece of logic that is referenced by a {@link com.intellivat.domain.taxtree.SimpleDecisionNode}.
 * It is being evaluated by the "processing engine" to determine the next node in the decision tree.
 *
 * @author Daniel Rosowski
 */
@JsonDeserialize( as = StaticDecisionRule.class )
public interface DecisionRule
    extends Comparable<DecisionRule> {

    String getId();

    String getTitle();

    void setTitle( String title );

    List<Parameter> getParameters();

    void setParameters( List<Parameter> parameters );

    List<ContextEntry> getContextEntryList();

    void setContextEntryList( List<ContextEntry> contextEntries );

    String getDecisionLogic();

    void setDecisionLogic( String decisionLogic );

    String getQuestion();

    void setQuestion( String question );

    String toString();


    /**
     * The builder can be used to build objects implementing the interface {@code DecisionRule}. Use the static factory
     * method {@link #newDecisionRule(String, Class)}.
     *
     * @author Daniel Rosowski
     */
    final class Builder<T extends DecisionRule> {
        private T instance;

        /**
         * Should only be instantiated through the static factory method!
         */
        private Builder() {}

        /**
         * Instantiates a new builder for the type given by the {@code clazz} parameter.
         *
         * @param id the {@link DecisionRule#getId()}
         * @param clazz
         * @return the builder
         */
        public static <T extends DecisionRule> Builder<T> newDecisionRule( String id, Class<T> clazz ) {
            Builder<T> builder = new Builder<T>();
            try {
                builder.instance = clazz.getDeclaredConstructor( String.class ).newInstance( id );
            }
            catch ( Exception e ) {
                throw new IllegalArgumentException( "Problem building decision rule!", e );
            }

            return builder;
        }

        /**
         * Assigns the given {@code parameters} to the decisionRules {@link DecisionRule#getParameters() parameters}.
         *
         * @param parameters
         * @return the builder
         */
        public Builder<T> withParameters( Parameter... parameters ) {
            instance.setParameters( Arrays.asList( parameters ) );
            return this;
        }

        /**
         * Assigns the given {@code parameters} to the decisionRules {@link DecisionRule#getParameters() parameters}.
         *
         * @param parameters
         * @return the builder
         */
        public Builder<T> withParameters( List<Parameter> parameters ) {
            instance.setParameters( parameters );
            return this;
        }

        /**
         * Assigns the given {@code constants} to the decisionRules {@link com.intellivat.domain.rules.DecisionRule#getContextEntryList()}  constants}.
         *
         * @param constants
         * @return the builder
         */
        public Builder<T> withContextEntries(ContextEntry... constants) {
            instance.setContextEntryList(Arrays.asList(constants));
            return this;
        }

        /**
         * Assigns the given {@code constants} to the decisionRules {@link com.intellivat.domain.rules.DecisionRule#getContextEntryList()}  constants}.
         *
         * @param constants
         * @return the builder
         */
        public Builder<T> withContextEntries( List<ContextEntry> constants ) {
            instance.setContextEntryList(constants);
            return this;
        }

        /**
         * Creates an {@link SimpleParameter} for each {@code parameterKey} and assigns it to the decisionRules
         * {@link DecisionRule#getParameters() parameters}.
         *
         * @return the builder
         */
        public Builder<T> withSimpleParameters(String... names) {
            List<Parameter> parameters = new ArrayList<>();
            for ( String name : names ) {
                parameters.add( new SimpleParameter( name ) );
            }
            instance.setParameters( parameters );
            return this;
        }

        /**
         * Assigns the {@code question} to the decisionRules {@link DecisionRule#getDecisionLogic() decisionLogic}.
         *
         * @param question
         * @return the decisionRule
         */
        public Builder<T> withQuestion( String question ) {
            instance.setQuestion( question );
            return this;
        }

        /**
         * Sets the {@code title} of the decisionRules
         *
         * @param title
         * @return
         */
        public Builder<T> withTitle( String title ) {
            instance.setTitle( title );
            return this;
        }

        /**
         * Assigns the {@code logic} to the decisionRules {@link DecisionRule#getDecisionLogic() decisionLogic}.
         *
         * @param logic
         * @return the decisionRule
         */
        public T andDecisionLogic( String logic ) {
            instance.setDecisionLogic( logic );
            return instance;
        }

    }

}
