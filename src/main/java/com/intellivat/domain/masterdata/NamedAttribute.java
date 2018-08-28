package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A NamedAttribute can be used (e.g. see {@link Jurisdiction#getActiveAttributes()})
 * by other classes to flag the existence of certain properties.
 */
@ViewableFields( {} )
public class NamedAttribute implements Masterdata{

    private final String name;

    @JsonCreator
    public NamedAttribute(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "NamedAttribute{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String masterdataKey() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamedAttribute that = (NamedAttribute) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
