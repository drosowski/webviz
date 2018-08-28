package com.intellivat.domain.taxtree;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.base.Preconditions;

/**
 * A decision node contains a reference to a {@code yesNode} and a {@code noNode}. These references are initialized with
 * a {@link Placeholder}, so we don't have to deal with null here.
 *
 * @author Daniel Rosowski
 */
@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
@JsonSubTypes( {
    @JsonSubTypes.Type( value = SimpleDecisionNode.class, name = "SimpleDecisionNode" ),
    } )
public abstract class DecisionNode
    extends TreeNode {

    private TreeNode yesNode;

    private TreeNode noNode;

    public DecisionNode() {
        super();
        init();
    }

    public DecisionNode( String id ) {
        super( id );
        init();
    }

    private void init() {
        this.noNode = new Placeholder();
        this.noNode.setPredecessor( this );
        this.yesNode = new Placeholder();
        this.yesNode.setPredecessor( this );
    }

    public TreeNode getYesNode() {
        return yesNode;
    }

    public void setYesNode( TreeNode yesNode ) {
        Preconditions.checkNotNull( yesNode );
        yesNode.setPredecessor( this );
        this.yesNode = yesNode;
    }

    public boolean hasYesNode() {
        return yesNode != null;
    }

    public TreeNode getNoNode() {
        return noNode;
    }

    public void setNoNode( TreeNode noNode ) {
        Preconditions.checkNotNull( noNode );
        noNode.setPredecessor( this );
        this.noNode = noNode;
    }

    public boolean hasNoNode() {
        return noNode != null;
    }

    @JsonIgnore
    public void setSuccessor( ConnectorType connector, TreeNode successorNode ) {
        Preconditions.checkNotNull( connector, successorNode );
        if ( connector.equals( ConnectorType.YES ) ) {
            setYesNode( successorNode );
        }
        else {
            setNoNode( successorNode );
        }
    }

    @JsonIgnore
    public TreeNode getSuccessor( ConnectorType connector ) {
        Preconditions.checkNotNull( connector );
        if ( connector.equals( ConnectorType.YES ) ) {
            return getYesNode();
        }
        return getNoNode();
    }

    /**
     * Replaces the given successor node with a new {@link Placeholder}
     *
     * @param successorNode
     */
    public void replaceSuccessorWithPlaceholder( TreeNode successorNode ) {
        if ( yesNode.equals( successorNode ) ) {
            setYesNode( new Placeholder() );
        }
        else if ( noNode.equals( successorNode ) ) {
            setNoNode( new Placeholder() );
        }

    }

    /**
     * Replaces the given successor node with a given {@link TreeNode}. If the replacer is null the successor will
     * replaced by a {@link Placeholder}
     *
     * @param successorNode
     */
    public void replaceSuccessorWithTreeNode( TreeNode successorNode,  Optional<TreeNode> replacer ) {
        if ( !replacer.isPresent() ) {
            replaceSuccessorWithPlaceholder( successorNode );
            return;
        }

        if ( yesNode.equals( successorNode ) ) {
            setYesNode( replacer.get() );
        }
        else if ( noNode.equals( successorNode ) ) {
            setNoNode( replacer.get() );
        }

    }
}
