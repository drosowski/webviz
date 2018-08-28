package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Strings;

import java.util.Objects;

/**
 * The tax type as indicated by the {@link TaxIndicator}.
 *
 */
@ViewableFields( { "localizedAbbreviation", "localizedName" } )
public class TaxType implements Masterdata {

    public final static TaxType NONE = new TaxType( "NONE", "NONE", "No Tax Type" );

    private final String localizedAbbreviation;

    private final String localizedName;

    private final String key;


    @JsonCreator
    public TaxType(@JsonProperty("key") String key,
                   @JsonProperty("localizedAbbreviation") String localizedAbbreviation,
                   @JsonProperty("localizedName") String localizedName) {
        this.localizedAbbreviation = Strings.nullToEmpty(localizedAbbreviation);
        this.localizedName = Strings.nullToEmpty(localizedName);
        this.key = key;
    }

    public String getLocalizedAbbreviation() {
        return localizedAbbreviation;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String masterdataKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxType taxType = (TaxType) o;
        return Objects.equals(key, taxType.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash( key);
    }

}
