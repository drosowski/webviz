package com.intellivat.domain.taxtree.builders;

import com.google.common.collect.Sets;
import com.intellivat.domain.taxtree.RootNode;
import com.intellivat.domain.taxtree.Subtree;
import com.intellivat.domain.taxtree.TaxDecisionTree;
import com.intellivat.domain.taxtree.Tree;

/**
 * This builder is used to build objects of type {@link Tree}.
 * 
 * @author Daniel Rosowski
 */
public final class TreeBuilder<T extends Tree> {

    private T tree;

    /**
     * Only the static factory methods should be used!
     */
    private TreeBuilder() {}

    /**
     * @return a new builder for a {@link TaxDecisionTree}.
     */
    public static TreeBuilder<TaxDecisionTree> newTaxTree() {
        TreeBuilder<TaxDecisionTree> treeBuilder = new TreeBuilder<TaxDecisionTree>();
        treeBuilder.tree = new TaxDecisionTree();
        return treeBuilder;
    }

    /**
     * @param name
     * @return a new builder for a {@link Subtree} with the given {@code name}.
     */
    public static TreeBuilder<Subtree> newSubtree( String name ) {
        TreeBuilder<Subtree> treeBuilder = new TreeBuilder<Subtree>();
        treeBuilder.tree = new Subtree( name );
        return treeBuilder;
    }

    /**
     * Sets the {@link Tree#getRootNode() rootNode}.
     * 
     * @param node
     * @return the builder
     */
    public TreeBuilder<T> withRootNode( RootNode node ) {
        tree.setRootNode( node );
        return this;
    }

    /**
     * Sets the {@link TaxDecisionTree#getSubtrees() subtrees}.
     * 
     * @param subtrees
     * @return the builder
     */
    public TreeBuilder<T> withSubtrees( Subtree... subtrees ) {
        if ( !( tree instanceof TaxDecisionTree ) ) {
            throw new IllegalArgumentException( "Subtrees cannot contain subtrees, only bookmarks!" );
        }
        for (Subtree subtree : subtrees) {
            ((TaxDecisionTree) tree).addSubtree(subtree);
        }
        return this;
    }


    /**
     * @return the tree
     */
    public T build() {
        return tree;
    }
}
