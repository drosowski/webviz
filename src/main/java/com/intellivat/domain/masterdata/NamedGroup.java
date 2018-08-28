package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableSet;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * An implementation of the LocationGroup interface with an arbitrary group name.
 */
@ViewableFields( { "includedLocations", "excludedLocations" } )
public class NamedGroup
    implements LocationGroup {

    private final String name;

    private final ImmutableSet<Location> includedLocations;

    private final ImmutableSet<Location> excludedLocations;

    public NamedGroup(String name){
        this(name, null, null);
    }

    public NamedGroup(String name, Set<Location> includedLocations){
        this(name, includedLocations, null);
    }

    @JsonCreator
    public NamedGroup(@JsonProperty("name") String name,
                      @JsonProperty("includedLocations") Set<Location> includedLocations,
                      @JsonProperty("excludedLocations") Set<Location> excludedLocations) {
        this.name = name;
        this.includedLocations = includedLocations == null ? ImmutableSet.of() : ImmutableSet.copyOf(includedLocations);
        this.excludedLocations = excludedLocations == null ? ImmutableSet.of() : ImmutableSet.copyOf(excludedLocations);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public ImmutableSet<Location> getIncludedLocations() {
        return includedLocations;
    }

    @Override
    public  ImmutableSet<Location> getExcludedLocations() {
        return excludedLocations;
    }

    @Override
    public String masterdataKey() {
        return name;
    }

    @Override
    public String toString() {
        return "LocationGroup{" +
                "name='" + name + '\'' +
                ", includedLocations=" +
                includedLocations.stream().map(l -> l.masterdataKey()).collect(Collectors.joining(", ")) +
                ", excludedLocations=" +
                excludedLocations.stream().map(l -> l.masterdataKey()).collect(Collectors.joining(", ")) +
                '}';
    }

    public boolean hasMemberLocation(final Location location) {
        boolean isNotExcluded = !excludedLocations.contains(location);
        return isNotExcluded && includedLocations.stream().anyMatch(included ->
                included.hasMemberLocation(location));
    }

    @Override
    public boolean hasMember(LocationGroup group) {
        return group.getIncludedLocations().stream()
                .allMatch(l -> hasMemberLocation(l));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamedGroup that = (NamedGroup) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(includedLocations, that.includedLocations) &&
                Objects.equals(excludedLocations, that.excludedLocations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, includedLocations, excludedLocations);
    }

}
