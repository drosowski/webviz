package com.intellivat.domain.taxtree;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The tree used to determine the tax type for each line on an invoice.
 * <p></p>
 * The decision tree is a binary tree, starting with a {@link SimpleDecisionNode rootNode} and ending with n
 * {@link ResultNode}s.
 *
 * @author Daniel Rosowski
 */
public class TaxDecisionTree
    implements Tree {

    private final UUID id;

    private RootNode rootNode;

    private Map<UUID, Subtree> subtrees = new HashMap<>();

    public TaxDecisionTree() {
        this.id = UUID.randomUUID();
    }

    @JsonCreator
    public TaxDecisionTree( @JsonProperty( "id" ) String id ) {
        this.id = UUID.fromString( id );
    }

    public UUID getId() {
        return id;
    }

    @Override
    public void setRootNode( RootNode node ) {
        this.rootNode = node;
    }

    @Override
    public RootNode getRootNode() {
        return rootNode;
    }

    public Collection<Subtree> getSubtrees() {
        return Collections.unmodifiableCollection(subtrees.values());
    }

    public void setSubtrees(Collection<Subtree> subtreeCollection){
        this.subtrees = subtreeCollection.stream()
                .collect(Collectors.toMap(Subtree::getId, Function.identity()));
    }

    @JsonIgnore
    public Optional<Subtree> getSubtreeByUUID(UUID subtreeId){
        return Optional.ofNullable(subtrees.get(subtreeId));
    }


    public void addSubtree( Subtree subtree ) {
        subtrees.put(subtree.getId(), subtree);
    }

    @Override
    public String toString() {
        return id.toString();
    }

    /**
     * Finds all nodes by type. Traverses the main tree and all subtrees.
     *
     * @param type
     * @return
     */
    public <T extends TreeNode> List<T> findNodesByType( Class<T> type ) {
        List<T> foundNodes = new ArrayList<T>();

        if ( rootNode != null ) {
            traverse( rootNode, type, foundNodes );
        }

        for ( Subtree subAlgorithm : getSubtrees() ) {
            traverse( subAlgorithm.getRootNode(), type, foundNodes );
        }

        return foundNodes;
    }

    @SuppressWarnings( "unchecked" )
    private <T extends TreeNode> void traverse( TreeNode node, Class<T> type, List<T> foundNodes ) {
        if ( type.isInstance( node ) ) {
            foundNodes.add( (T) node );
        }

        if ( node instanceof DecisionNode ) {
            DecisionNode predecessor = (DecisionNode) node;
            if ( predecessor.hasYesNode() ) {
                traverse( predecessor.getYesNode(), type, foundNodes );
            }
            if ( predecessor.hasNoNode() ) {
                traverse( predecessor.getNoNode(), type, foundNodes );
            }
        }
    }

    /**
     * Finds the {@code tree} containing the given {@code node}.
     *
     * @param node
     * @return
     */
    public Optional<Tree> findTreeContainingNode( TreeNode node ) {

        if ( nodeStructureContainsNode( getRootNode(), node ) ) {
            return Optional.of( this );
        }

        for ( Subtree subtree : getSubtrees() ) {
            if ( nodeStructureContainsNode( subtree.getRootNode(), node ) ) {
                return Optional.of( subtree );
            }
        }

        return Optional.empty();
    }

    private boolean nodeStructureContainsNode( DecisionNode startNode, TreeNode wantedNode ) {
        if (startNode == null){
            return false;
        }
        if ( startNode.equals( wantedNode ) ) {
            return true;
        }

        TreeNode yesNode = startNode.getYesNode();
        TreeNode noNode = startNode.getNoNode();
        if ( yesNode.equals( wantedNode ) || noNode.equals( wantedNode ) ) {
            return true;
        }

        if ( yesNode.isDecisionNode() && nodeStructureContainsNode( (DecisionNode) yesNode, wantedNode ) ) {
            return true;
        }
        if ( noNode.isDecisionNode() && nodeStructureContainsNode( (DecisionNode) noNode, wantedNode ) ) {
            return true;
        }

        return false;
    }

    /**
     * Removes a {@link Subtree} if it exists.
     *
     * @param subtree
     */
    public void removeSubtree( Subtree subtree ) {
        if (subtrees.containsKey(subtree.getId())) {
            subtrees.remove( subtree.getId() );
        }
    }

}
