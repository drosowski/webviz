package com.intellivat.domain.taxtree;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * Holds information about the nodes that have been {@link #getTraversedNodes() traversed} in order to evaluate the
 * {@link #getLeaf() leaf} node. Should only be needed during the simulation of a {@code taxTree}.
 * 
 * @author Daniel Rosowski
 */
public class EvaluationSteps {

    public static final EvaluationSteps EMPTY_STEPS = new EvaluationSteps(ImmutableList.of());

    private final ImmutableList<TreeNode> traversedNodes;

    @JsonCreator
    public EvaluationSteps(@JsonProperty("traversedNodes") List<TreeNode> traversedNodes) {
        this.traversedNodes = ImmutableList.copyOf(traversedNodes);
    }

    @JsonIgnore
    public Optional<Leaf> getLeaf() {
        TreeNode leafCandidate = Iterables.getLast(traversedNodes, null);
        if (leafCandidate != null && leafCandidate.isLeaf()){
            return Optional.of((Leaf) leafCandidate);
        } else {
            return Optional.empty();
        }
    }

    public List<TreeNode> getTraversedNodes() {
        return Collections.unmodifiableList( traversedNodes );
    }

    public EvaluationSteps addTraversedNode( TreeNode node ) {
        ImmutableList<TreeNode> traversed = new ImmutableList.Builder<TreeNode>().addAll(traversedNodes).add(node).build();
        return new EvaluationSteps(traversed);
    }


    @Override
    public boolean equals( Object obj ) {
        if ( !( obj instanceof EvaluationSteps ) ) {
            return false;
        }

        EvaluationSteps other = (EvaluationSteps) obj;
        return Objects.equal( traversedNodes, other.traversedNodes );
    }

    @Override
    public int hashCode() {
        return Objects.hashCode( traversedNodes );
    }
}
