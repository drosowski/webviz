package com.intellivat.domain.taxtree;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A subtree is a nested structure that contains a tree structure, starting with the {@code rootNode}. Iit must end with {@link ResultNode}s or {@link SubtreeBookmark}s.
 * 
 * @author Daniel Rosowski
 */
public class Subtree
    implements Tree {

    private final UUID id;

    private String name;

    private RootNode rootNode;

    public Subtree() {
        this.id = UUID.randomUUID();
    }

    public Subtree( String name ) {
        this.name = name;
        this.id = UUID.randomUUID();
    }

    @JsonCreator
    public Subtree( @JsonProperty( "id" ) String id, @JsonProperty( "name" ) String name ) {
        this.id = UUID.fromString( id );
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Override
    public RootNode getRootNode() {
        return rootNode;
    }

    @Override
    public void setRootNode( RootNode rootNode ) {
        this.rootNode = rootNode;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }

        final Subtree other = (Subtree) obj;
        return Objects.equals( this.id, other.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.id );
    }

}
