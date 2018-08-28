package com.intellivat.domain.taxtree;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Special end node that marks an exceptional case, like "not supported" or "error".
 *
 * @author Daniel Rosowski
 */
public class ExceptionNode
    extends TreeNode
    implements Leaf {

    private String type;

    @JsonCreator
    public ExceptionNode( @JsonProperty( "type" ) String type ) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    @Override
    public boolean dataEquals( Leaf leaf ) {
        if ( leaf == null ) {
            return false;
        }
        if ( getClass() != leaf.getClass() ) {
            return false;
        }

        final ExceptionNode other = (ExceptionNode) leaf;
        return Objects.equals( this.type, other.type );
    }
}
