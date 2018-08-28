package com.intellivat.domain.taxtree;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intellivat.domain.rules.DecisionRule;

public class RootNode
    extends SimpleDecisionNode {

    public RootNode( DecisionRule decisionRule ) {
        super( decisionRule );
    }

    @JsonCreator
    public RootNode( @JsonProperty( "id" ) String id, @JsonProperty( "decisionRule" ) DecisionRule decisionRule ) {
        super( id, decisionRule );
    }
}
