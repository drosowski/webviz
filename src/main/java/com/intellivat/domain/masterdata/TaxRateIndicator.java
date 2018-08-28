package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A TaxRateIndicator consists of a key and a name
 */
@ViewableFields( { "name" } )
public class TaxRateIndicator implements Masterdata{

    private final String key;

    private final String name;

    @JsonCreator
    public TaxRateIndicator(@JsonProperty("key") String key,
                            @JsonProperty("name") String name) {
        this.name = name;
        this.key = key;
    }


    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "TaxRateIndicator{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxRateIndicator that = (TaxRateIndicator) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name);
    }

    @Override
    public String masterdataKey() {
        return key;
    }

}
