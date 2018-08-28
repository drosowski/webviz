package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableSet;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A general purpose company class to be used in an invoice.
 */
@ViewableFields( { "address", "taxRegistrations" } )
public class Company
    implements Masterdata {

    private final String customId;

    private final Location address;

    private final ImmutableSet<TaxRegistration> taxRegistrations;

    /**
     * @param customId a reference to the customer's data in the source system.
     * @param address For now the only address information we need to store is the location. In the future there might
     *            be need for more, but for the current taxation process this is sufficient.
     * @param taxRegistrations a Set of taxRegistration associated with the company.
     */
    @JsonCreator
    public Company( @JsonProperty( "customId" ) String customId,
                    @JsonProperty( "address" ) Location address,
                    @JsonProperty( "taxRegistrations" ) Set<TaxRegistration> taxRegistrations ) {
        this.customId = customId;
        this.address = address;
        this.taxRegistrations = ImmutableSet.copyOf( taxRegistrations );
    }

    public Company( String customId, Location address ) {
        this( customId, address, ImmutableSet.of() );
    }

    public Location getAddress() {
        return address;
    }

    public String getCustomId() {
        return customId;
    }

    public ImmutableSet<TaxRegistration> getTaxRegistrations() {
        return taxRegistrations;
    }

    @Override
    public String masterdataKey() {
        return getCustomId();
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Company company = (Company) o;
        return Objects.equals( customId, company.customId ) &&
            Objects.equals( address, company.address ) &&
            Objects.equals( taxRegistrations, company.taxRegistrations );
    }

    @Override
    public int hashCode() {
        return Objects.hash( customId, address, taxRegistrations );
    }

    @Override
    public String toString() {
        return "Company{" +
            "customId='" + customId + '\'' +
            ", address=" + address.masterdataKey() +
            ", taxRegistrations=" + taxRegistrations.stream().map( TaxRegistration::toString ).collect( Collectors.joining( ", " ) ) +
            '}';
    }

}
