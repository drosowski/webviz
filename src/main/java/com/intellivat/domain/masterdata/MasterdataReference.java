package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import com.intellivat.domain.rules.ParameterValue;

/**
 * Represents a single masterdata object to be used to reference to the concrete Masterdata, e.g. inside
 * {@link com.intellivat.domain.rules.ParameterValue}s in {@link com.intellivat.domain.taxtree.DecisionNode}s.
 */
public class MasterdataReference
    implements ParameterValue {

    private final String masterdataId;

    private final Class<? extends Masterdata> type;

    @JsonCreator
    public MasterdataReference( @JsonProperty( "masterdataId" ) String masterdataId,
                                @JsonProperty( "type" ) Class<? extends Masterdata> type ) {
        Preconditions.checkNotNull( masterdataId );
        Preconditions.checkNotNull( type );
        this.masterdataId = masterdataId;
        this.type = type;
    }

    public static MasterdataReference of( Masterdata masterdata ) {
        return new MasterdataReference( masterdata.masterdataKey(), masterdata.getClass() );
    }

    public String getMasterdataId() {
        return masterdataId;
    }

    public Class<? extends Masterdata> getType() {
        return type;
    }

    @Override
    @JsonIgnore
    public String getDisplayName() {
        return masterdataId;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;

        MasterdataReference that = (MasterdataReference) o;

        if ( !masterdataId.equals( that.masterdataId ) )
            return false;
        if ( !type.equals( that.type ) )
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = masterdataId.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }

}
