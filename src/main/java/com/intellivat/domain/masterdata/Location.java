package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.collect.ImmutableSet;

import java.util.Objects;
import java.util.Optional;

/**
 * A Location represents a specific geographical area at different {@link LocationLevel levels}. A Location may have a
 * parent Location on a higher level, eg. State NRW -&gt; parent Country DE. Also the {@link LocationGroup} interface is
 * implemented.
 */
@ViewableFields( { "level", "parent" } )
@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
public class Location
    implements LocationGroup {

    private final String key;

    private final LocationLevel level;

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
    private final Optional<Location> parent;

    public Location( String key ) {
        this( key, LocationLevel.COUNTRY, null );
    }

    public Location( String key, LocationLevel level ) {
        this( key, level, null );
    }

    @JsonCreator
    public Location( @JsonProperty( "key" ) String key,
                     @JsonProperty( "level" ) LocationLevel level,
                     @JsonProperty( "parent" ) Location parent ) {
        this.key = key;
        this.level = level;
        this.parent = Optional.ofNullable( parent );
    }

    public String getKey() {
        return key;
    }

    public LocationLevel getLevel() {
        return level;
    }

    public Optional<Location> getParent() {
        return parent;
    }

    @Override
    public String masterdataKey() {
        return level.name() + '-' + key;
    }

    @JsonIgnore
    @Override
    public String getName() {
        return masterdataKey();
    }

    @JsonIgnore
    @Override
    public ImmutableSet<Location> getIncludedLocations() {
        return ImmutableSet.of( this );
    }

    @JsonIgnore
    @Override
    public ImmutableSet<Location> getExcludedLocations() {
        return ImmutableSet.of();
    }

    public boolean hasMemberLocation( Location locationToTest ) {
        if ( locationToTest == null ) {
            return false;
        }
        else if ( this.equals( locationToTest ) ) {
            return true;
        }
        else
            return locationToTest.parent.isPresent() && locationToTest.parent.get().equals( this );
    }

    @Override
    public boolean hasMember( LocationGroup group ) {
        return group.getIncludedLocations().stream()
            .allMatch(
                l -> hasMemberLocation( l ) );
    }

    @Override
    public String toString() {
        return "Location{" +
            "key='" + key + '\'' +
            ", level=" + level +
            ", parent=" + parent +
            '}';
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Location location = (Location) o;
        return Objects.equals( key, location.key ) &&
            Objects.equals( level, location.level ) &&
            Objects.equals( parent, location.parent );
    }

    @Override
    public int hashCode() {
        return Objects.hash( key, level, parent );
    }

    public static Location createState( String stateKey, String countryKey ) {
        return new Location( stateKey, LocationLevel.STATE, new Location( countryKey ) );
    }
}
