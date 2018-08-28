package com.intellivat.domain.taxtree;

import java.time.Instant;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The TaxTreeReference describes the validity key of a tax decision tree. This class could be used to load a certain
 * tree from tdis.
 */
public class TaxTreeReference {

    private Instant snapshotTime;

    private LocalDate taxPoint;

    @JsonCreator
    public TaxTreeReference( @JsonProperty( "snapshotTime" ) Instant snapshotTime, @JsonProperty( "taxPoint" ) LocalDate taxPoint ) {
        this.snapshotTime = snapshotTime;
        this.taxPoint = taxPoint;
    }

    public Instant getSnapshotTime() {
        return snapshotTime;
    }

    public LocalDate getTaxPoint() {
        return taxPoint;
    }

}
