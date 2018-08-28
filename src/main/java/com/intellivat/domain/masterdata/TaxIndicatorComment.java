package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@ViewableFields( { "taxIndicator", "locale", "jurisdiction", "view", "text" } )
public class TaxIndicatorComment
                implements Masterdata {

    public enum View {SELLER, BUYER, BOTH}

    private final TaxIndicator taxIndicator;

    private final Locale locale;

    private final String text;

    private final Jurisdiction jurisdiction;

    private final View view;

    @JsonCreator
    public TaxIndicatorComment( @JsonProperty( "taxIndicator" ) TaxIndicator taxIndicator,
                                @JsonProperty( "locale" ) Locale locale,
                                @JsonProperty( "jurisdiction" ) Jurisdiction jurisdiction,
                                @JsonProperty( "view" ) View view,
                                @JsonProperty( "text" ) String text ) {
        this.taxIndicator = taxIndicator;
        this.locale = locale;
        this.jurisdiction = jurisdiction;
        this.view = view;
        this.text = text;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getText() {
        return text;
    }

    public TaxIndicator getTaxIndicator() {
        return taxIndicator;
    }

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
    public Optional<Jurisdiction> getJurisdiction() {
        return Optional.ofNullable( jurisdiction );
    }

    public View getView() {
        return view;
    }

    @Override
    public String masterdataKey() {
        String jurisdictionKey = jurisdiction == null ? "-" : jurisdiction.masterdataKey();
        return String.format( "comment-%s-%s-%s-%s", taxIndicator.masterdataKey(), locale.toLanguageTag(), jurisdictionKey, view );
    }


    @Override
    public String toString() {
        return "TaxIndicatorComment{" +
                "taxIndicator=" + taxIndicator +
                ", locale=" + locale +
                ", jurisdiction=" + jurisdiction +
                ", view=" + view +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        TaxIndicatorComment that = (TaxIndicatorComment) o;
        return Objects.equals( taxIndicator, that.taxIndicator ) &&
                Objects.equals( locale, that.locale ) &&
                Objects.equals( text, that.text ) &&
                Objects.equals( jurisdiction, that.jurisdiction ) &&
                Objects.equals( view, that.view );
    }

    @Override
    public int hashCode() {
        return Objects.hash( taxIndicator, locale, text, jurisdiction, view );
    }
}
