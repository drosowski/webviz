package com.intellivat.domain.taxtree;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Represents a node in the {@link TaxDecisionTree}.
 * 
 * @author Daniel Rosowski
 */
@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
@JsonSubTypes( {
    @JsonSubTypes.Type( value = DecisionNode.class ),
    @JsonSubTypes.Type( value = ExceptionNode.class ),
    @JsonSubTypes.Type( value = ResultNode.class ),
    @JsonSubTypes.Type( value = Placeholder.class ),
    @JsonSubTypes.Type( value = SubtreeBookmark.class ) } )
public abstract class TreeNode {

    private final UUID id;

    /**
     * Can be ignore for serialization, since it is rebuild on deserialization using setYesNode/setNoNode.
     */
    @JsonIgnore
    private Optional<DecisionNode> predecessor = Optional.empty();

    public TreeNode() {
        id = UUID.randomUUID();
    }

    public TreeNode( String id ) {
        this.id = UUID.fromString( id );
    }

    public UUID getId() {
        return id;
    }

    public Optional<DecisionNode> getPredecessor() {
        return predecessor;
    }

    public void setPredecessor( Optional<DecisionNode> predecessor ) {
        this.predecessor = predecessor;
    }

    public void setPredecessor( DecisionNode predecessor ) {
        this.predecessor = Optional.ofNullable( predecessor );
    }

    public boolean hasPredecessor() {
        return predecessor.isPresent();
    }

    @JsonIgnore
    public boolean isLeaf() {
        return this instanceof Leaf;
    }

    @JsonIgnore
    public boolean isSubtreeBookmark() {
        return this instanceof SubtreeBookmark;
    }

    @JsonIgnore
    public boolean isRootNode() {
        return this instanceof RootNode;
    }

    @JsonIgnore
    public boolean isDecisionNode() {
        return this instanceof DecisionNode;
    }

    @JsonIgnore
    public boolean isResultNode() {
        return this instanceof ResultNode;
    }

    @JsonIgnore
    public boolean isPlaceholder() {
        return this instanceof Placeholder;
    }

    @JsonIgnore
    public boolean isSimpleDecisionNode() {
        return this instanceof SimpleDecisionNode;
    }

    @JsonIgnore
    public boolean isExceptionNode() {
        return this instanceof ExceptionNode;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }

        final TreeNode other = (TreeNode) obj;
        return Objects.equals( this.id, other.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.id );
    }

}
