package com.intellivat.domain.taxtree;

import java.util.Collections;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * A placeholder node is placed on each {@link DecisionNode#getYesNode() yes} and {@link DecisionNode#getNoNode() no}
 * node per default. It can be thought of as a NullObject implementation for TreeNode.
 * 
 * @author Daniel Rosowski
 */
public class Placeholder
    extends TreeNode {

    private final Set<Class<? extends TreeNode>> allowedSurrogators;

    /**
     * Initializes the placeholder with the standard allowed surrogators, including
     * <ul>
     * <li>SimpleDecisionNode</li>
     * <li>ResultNode</li>
     * <li>ExceptionNode</li>
     * <li>SubtreeBookmark</li>
     * </ul>
     */
    @SuppressWarnings( "unchecked" )
    public Placeholder() {
        allowedSurrogators = Sets.newHashSet(
            SimpleDecisionNode.class,
            ResultNode.class,
            ExceptionNode.class,
            SubtreeBookmark.class );
    }

    /**
     * Initialize the placeholder with the given {@code allowedSurrogators}.
     * 
     * @param allowedSurrogators
     */
    public Placeholder( Class<? extends TreeNode>... allowedSurrogators ) {
        this.allowedSurrogators = Sets.newHashSet( allowedSurrogators );
    }

    public Set<Class<? extends TreeNode>> getAllowedSurrogators() {
        return Collections.unmodifiableSet( allowedSurrogators );
    }
}
