package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.intellivat.domain.invoice.TaxPointOption;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

/**
 * The jurisdiction holds the tax information for a {@link LocationGroup}. In most countries this is only the country
 * itself. Some countries like Canada and India have tax jurisdictions also on provincial/state level.
 */
@ViewableFields( { "locationGroup", "taxType", "level", "locationLevel",
                "locales", "taxPointOption", "defaultCurrency", "activeAttributes" } )
@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
public class Jurisdiction implements Masterdata{

    private final String key;

    private final LocationGroup locationGroup;

    private final TaxType taxType;

    private final TaxCalculationLevel level;

    private final LocationLevel locationLevel;

    private final ImmutableList<Locale> locales;

    private final TaxPointOption taxPointOption;

    private final Currency defaultCurrency;

    private final ImmutableSet<NamedAttribute> activeAttributes;

    public Jurisdiction( String key, LocationGroup locationGroup, List<Locale> locales,
                         TaxType taxType,
                         TaxCalculationLevel level,
                         Currency defaultCurrency,
                         ImmutableSet<NamedAttribute> activeAttributes ) {
        this( key, locationGroup, locales, taxType, LocationLevel.COUNTRY, level,
                        TaxPointOption.INVOICE_DATE, defaultCurrency, activeAttributes );
    }

    @JsonCreator
    public Jurisdiction(@JsonProperty("key") String key,
                        @JsonProperty("locationGroup") LocationGroup locationGroup,
                        @JsonProperty( "locales" ) List<Locale> locales,
                        @JsonProperty("taxType") TaxType taxType,
                        @JsonProperty("locationLevel") LocationLevel locationLevel,
                        @JsonProperty("level") TaxCalculationLevel level,
                        @JsonProperty("taxPointOption") TaxPointOption taxPointOption,
                        @JsonProperty("defaultCurrency") Currency defaultCurrency,
                        @JsonProperty("activeAttributes") Set<NamedAttribute> activeAttributes) {
        this.key = key;
        this.locationGroup = locationGroup;
        this.locales = ImmutableList.copyOf( locales );
        this.taxType = taxType;
        this.level = level;
        this.taxPointOption = taxPointOption;
        this.defaultCurrency = defaultCurrency;
        this.locationLevel = locationLevel;
        this.activeAttributes = ImmutableSet.copyOf(activeAttributes);
    }


    public LocationGroup getLocationGroup() {
        return locationGroup;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public LocationLevel getLocationLevel() {
        return locationLevel;
    }

    public TaxCalculationLevel getLevel() {
        return level;
    }

    public TaxPointOption getTaxPointOption() {
        return taxPointOption;
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public ImmutableSet<NamedAttribute> getActiveAttributes() {
        return activeAttributes;
    }

    public String getKey() { return key; }

    @Override
    public String toString() {
        return "Jurisdiction{" + key + "}";
    }

    @Override
    public String masterdataKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jurisdiction that = (Jurisdiction) o;
        return Objects.equals(locationGroup, that.locationGroup) &&
                Objects.equals( key, that.key ) &&
                Objects.equals(taxType, that.taxType) &&
                Objects.equals(locationLevel, that.locationLevel) &&
                        Objects.equals( locales, that.locales ) &&
                Objects.equals(level, that.level) &&
                Objects.equals(taxPointOption, that.taxPointOption) &&
                Objects.equals(defaultCurrency, that.defaultCurrency) &&
                Objects.equals(activeAttributes, that.activeAttributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash( key, locationGroup, taxType, locationLevel, locales, level, taxPointOption, defaultCurrency,
                        activeAttributes );
    }

}
