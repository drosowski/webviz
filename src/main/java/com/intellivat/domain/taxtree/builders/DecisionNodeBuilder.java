package com.intellivat.domain.taxtree.builders;

import com.intellivat.domain.taxtree.DecisionNode;
import com.intellivat.domain.taxtree.TreeNode;

/**
 * Abstract builder used by all nodes extending {@link DecisionNode}. Needs to be parameterized with the actual type
 * (use the {@link NodeFactory}!)
 * 
 * @author Daniel Rosowski
 */
public abstract class DecisionNodeBuilder<T extends DecisionNode> {

    private T instance;

    public void setInstance( T instance ) {
        this.instance = instance;
    }

    public T getInstance() {
        return instance;
    }

    /**
     * Adds a {@link DecisionNode#setYesNode(TreeNode) yes node}.
     * 
     * @param yesNode
     * @return the builder
     */
    public DecisionNodeBuilder<T> andYesNode( TreeNode yesNode ) {
        instance.setYesNode( yesNode );
        return this;
    }

    /**
     * Adds a {@link DecisionNode#setNoNode(TreeNode) no node}.
     * 
     * @param noNode
     * @return the builder
     */
    public DecisionNodeBuilder<T> andNoNode( TreeNode noNode ) {
        instance.setNoNode( noNode );
        return this;
    }

    /**
     * @return the decision node
     */
    public T build() {
        return instance;
    }
}
