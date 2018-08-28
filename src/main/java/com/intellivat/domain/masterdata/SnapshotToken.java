package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Objects;

public class SnapshotToken {

    private final Instant timestamp;

    @JsonCreator
    public SnapshotToken( @JsonProperty( "timestamp" ) Instant timestamp ) {
        this.timestamp = timestamp;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnapshotToken that = (SnapshotToken) o;
        return Objects.equals( timestamp, that.timestamp );
    }

    @Override
    public int hashCode() {
        return Objects.hash( timestamp );
    }

    @Override
    public String toString() {
        return "SnapshotToken{" +
                        "timestamp='" + timestamp + '\'' +
                '}';
    }
}
