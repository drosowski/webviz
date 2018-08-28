package com.intellivat.domain.taxtree.builders;

import com.intellivat.domain.rules.DecisionRuleRepository;
import com.intellivat.domain.taxtree.*;

/**
 * A factory used for building the various types of {@link TreeNode}s.
 * 
 * @author Daniel Rosowski
 */
public class NodeFactory {

    private DecisionRuleRepository ruleRepository;

    public NodeFactory( DecisionRuleRepository ruleRepository ) {
        this.ruleRepository = ruleRepository;
    }

    /**
     * @param ruleId
     * @return a new builder for a {@code decisionNode} using the rule given by {@code ruleId}.
     */
    public SimpleDecisionNodeBuilder<SimpleDecisionNode> newDecisionNodeFromRule( String ruleId ) {
        return new SimpleDecisionNodeBuilder<SimpleDecisionNode>( ruleRepository ).newDecisionNodeFromRule( ruleId,
            SimpleDecisionNode.class );
    }

    /**
     * @param ruleId
     * @return a new builder for a {@link RootNode} using the rule given by {@code ruleId}.
     */
    public SimpleDecisionNodeBuilder<RootNode> newRootNodeFromRule( String ruleId ) {
        return new SimpleDecisionNodeBuilder<RootNode>( ruleRepository ).newDecisionNodeFromRule( ruleId,
            RootNode.class );
    }

    /**
     * @return a new builder for a {@link ResultNode} using the rule given by {@code ruleId}.
     */
    public ResultNodeBuilder newResultNode() {
        return new ResultNodeBuilder();
    }

}
