package com.intellivat.domain.masterdata;

import com.google.common.collect.ImmutableSet;

/**
 * A LocationGroup is defined by a name {@link #getName()} and a set of inluded {@link #getIncludedLocations() included}
 * and {@link #getExcludedLocations() excluded} {@link Location}s.
 */
public interface LocationGroup
    extends Masterdata {

    String getName();

    ImmutableSet<Location> getIncludedLocations();

    ImmutableSet<Location> getExcludedLocations();

    /**
     * Group membership test for (Sub-)Groups
     * 
     * @param groupToBeTested Group to be tested for membership
     * @return true, if the given group is part of this group
     */
    boolean hasMember( LocationGroup groupToBeTested );

}
