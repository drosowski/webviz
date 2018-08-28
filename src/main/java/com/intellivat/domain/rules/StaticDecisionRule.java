package com.intellivat.domain.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A static implementation of the {@link DecisionRule} mainly for tests.
 *
 * @author Daniel Rosowski
 */
public class StaticDecisionRule
    implements DecisionRule {

    private final String id;

    private List<Parameter> parameters = new ArrayList<>();

    private List<ContextEntry> contextEntries = new ArrayList<>();

    private String decisionLogic;

    private String question;

    private String title;

    @JsonCreator
    public StaticDecisionRule( @JsonProperty( "id" ) String id ) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public List<Parameter> getParameters() {
        return parameters;
    }

    @Override
    public void setParameters( List<Parameter> parameters ) {
        this.parameters = parameters;
    }

    @Override
    public List<ContextEntry> getContextEntryList() {
        return contextEntries;
    }

    @Override
    public void setContextEntryList( List<ContextEntry> contextEntries ) {
        this.contextEntries = contextEntries;
    }

    @Override
    public String getDecisionLogic() {
        return decisionLogic;
    }

    @Override
    public void setDecisionLogic( String decisionLogic ) {
        this.decisionLogic = decisionLogic;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setQuestion( String question ) {
        this.question = question;
    }

    @Override
    public String toString() {
        return getTitle();
    }

    @Override
    public void setTitle( String title ) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public int compareTo( DecisionRule other ) {
        return question.compareTo( other.getQuestion() );
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }

        final DecisionRule other = (DecisionRule) obj;
        return Objects.equals( this.id, other.getId() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.id );
    }
}
