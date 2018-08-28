package com.intellivat.domain.taxtree;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 * A Bookmark to a {@link Subtree}.
 *
 * @author Daniel Rosowski
 */
public class SubtreeBookmark
    extends TreeNode{

    private UUID subtreeId;
    private String subtreeName;

    @JsonCreator
    public SubtreeBookmark( @JsonProperty( "subtreeId" ) UUID subtreeId,
                            @JsonProperty( "subtreeName") String subtreeName) {
        this.subtreeId = subtreeId;
        this.subtreeName = subtreeName;
    }

    public SubtreeBookmark(Subtree subtree){
        this(subtree.getId(), subtree.getName());
    }

    public UUID getSubtreeId() {
        return subtreeId;
    }

    public void setSubtreeId(UUID subtreeId) {
        this.subtreeId = subtreeId;
    }

    public String getSubtreeName() {
        return subtreeName;
    }

    public void setSubtreeName(String subtreeName) {
        this.subtreeName = subtreeName;
    }
}
