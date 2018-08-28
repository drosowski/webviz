package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * Representation of the VAT-related classification, which has to be added to an UNSPSC classification (e.g. to classify
 * items as goods or different types of services).
 *
 * @author Alexander Niemann
 */
@ViewableFields( { "unspscClass", "type" } )
public class UnspscClassification implements Masterdata{

    private final UnspscClass unspscClass;

    private final String type;


    @JsonCreator
    public UnspscClassification( @JsonProperty( "unspscClass" ) UnspscClass unspscClass,
                                 @JsonProperty( "type" ) String type ) {
        this.unspscClass = unspscClass;
        this.type = type;
    }

    public UnspscClass getUnspscClass() {
        return unspscClass;
    }

    public Optional<String> getType() {
        return Optional.ofNullable( type );
    }

    @Override
    public String toString() {
        return "[UNSPSC Classification " + unspscClass.getName() + " / " + getType().orElse( "--" );
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnspscClassification that = (UnspscClassification) o;
        return Objects.equals(unspscClass, that.unspscClass) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unspscClass, type);
    }

    @Override
    public String masterdataKey() {
        return unspscClass.name() + '-' + type;
    }
}
