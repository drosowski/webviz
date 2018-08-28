package com.intellivat.domain.taxtree;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intellivat.domain.masterdata.LocationLevel;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Objects;

/**
 * The results node contains all the information that is necessary to determine the tax rate for an invoice line. It
 * defines the endpoint in the {@link TaxDecisionTree}, yielding no further yes or node node.
 *
 * @author Daniel Rosowski
 */
public class ResultNode
    extends TreeNode
    implements Leaf {

    @JsonProperty
    private final EnumMap<LocationLevel, Result> results;

    public ResultNode() {
        super();
        results = new EnumMap<>( LocationLevel.class );
    }

    @JsonCreator
    public ResultNode( @JsonProperty( "id" ) String id, @JsonProperty( "results" ) EnumMap<LocationLevel, Result> results ) {
        super( id );
        this.results = results;
    }

    public Result getResult( LocationLevel locationLevel ) {
        return results.get( locationLevel );
    }

    public void setResult( LocationLevel locationLevel, Result result ) {
        results.put( locationLevel, result );
    }

    @JsonIgnore
    public EnumMap<LocationLevel, Result> getResults() {
        return results;
    }


    @Override
    public boolean dataEquals( Leaf leaf ) {
        if ( leaf == null ) {
            return false;
        }
        if ( getClass() != leaf.getClass() ) {
            return false;
        }

        final ResultNode other = (ResultNode) leaf;
        return Arrays.stream( LocationLevel.values() )
                .allMatch(t -> Objects.equals(this.results.get(t), other.getResult(t)));
    }

    @Override
    public String toString() {
        return "ResultNode{" +
                "results=" + results +
                '}';
    }
}
