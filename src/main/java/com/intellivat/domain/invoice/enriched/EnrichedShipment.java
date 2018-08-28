package com.intellivat.domain.invoice.enriched;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import com.intellivat.domain.masterdata.Location;

import java.util.Objects;

/**
 * Includes information for shipped goods, such as from where and when goods were shipped.
 * 
 * @author Alex Rommel
 */
public class EnrichedShipment {

    private Location shipFrom;

    private Location shipTo;

    @JsonCreator
    public EnrichedShipment(@JsonProperty("shipFrom") Location shipFrom,
                            @JsonProperty("shipTo") Location shipTo){
        Preconditions.checkNotNull(shipFrom);
        Preconditions.checkNotNull(shipTo);
        this.shipFrom = shipFrom;
        this.shipTo = shipTo;
    }


    public Location getShipFrom() {
        return shipFrom;
    }

    public Location getShipTo() {
        return shipTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrichedShipment that = (EnrichedShipment) o;
        return Objects.equals(shipFrom, that.shipFrom) &&
                Objects.equals(shipTo, that.shipTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipFrom, shipTo);
    }
}
