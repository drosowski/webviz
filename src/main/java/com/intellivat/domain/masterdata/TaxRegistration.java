package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A Tax Registration is composed of a tax registration number and a
 * {@link com.intellivat.domain.masterdata.Jurisdiction}
 *
 * @author sascharodekamp
 */
@ViewableFields( { "registrationNumber", "jurisdiction" } )
public class TaxRegistration implements Masterdata{

    private final String registrationNumber;
    private final Jurisdiction jurisdiction;

    @JsonCreator
    public TaxRegistration(@JsonProperty("registrationNumber") String registrationNumber,
                           @JsonProperty("jurisdiction") Jurisdiction jurisdiction) {
        this.jurisdiction = jurisdiction;
        this.registrationNumber = registrationNumber;
    }

    public Jurisdiction getJurisdiction() {
        return jurisdiction;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }


    @Override
    public String toString() {
        return "TaxRegistration{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", jurisdiction=" + jurisdiction.masterdataKey() +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxRegistration that = (TaxRegistration) o;
        return Objects.equals(registrationNumber, that.registrationNumber) &&
                Objects.equals(jurisdiction, that.jurisdiction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber, jurisdiction);
    }

    @Override
    public String masterdataKey() {
        return registrationNumber + '-' + jurisdiction.masterdataKey();
    }

}
