package com.intellivat.domain.invoice;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import ognl.NoSuchPropertyException;
import ognl.Ognl;
import ognl.OgnlException;

/**
 * Takes an {@link InvoiceReference} and an {@code invoice} and gets values according to the
 * {@code invoiceReference}s {@link InvoiceReference#getQueryPath() queryPath}.
 *
 * @author Daniel Rosowski
 */
public class InvoiceAccessor {

    /**
     * Accesses the {@code invoice} and determines the value referenced by {@code ref}. Returns {@link Optional#empty()}
     * if the value or one of its parents is null.
     *
     * @param ref the reference to the field on the line item.
     * @param invoice the root object on which the reference gets applied
     * @return an Optional containing the value or {@link Optional#empty()} if no value has been found.
     */
    public <T> Optional<T> getOptionalValue( InvoiceReference ref, Invoice invoice ) {
        return getValueForReference( ref, invoice, null );
    }

    /**
     * Accesses the {@code invoice} and determines the value referenced by {@code ref}.
     *
     * @param ref the reference to the field on the line item.
     * @param invoice the root object on which the reference gets applied
     * @return the value or {@link Optional#empty()} if no value has been found.
     * @throws MissingInvoiceValueException if the value or one of its parents is null
     */
    public <T> T getRequiredValue( InvoiceReference ref, Invoice invoice )
        throws MissingInvoiceValueException {
        Optional<T> value = getValueForReference( ref, invoice, null );
        if ( !value.isPresent() ) {
            throw new MissingInvoiceValueException( ref, invoice );
        }
        return value.get();
    }

    /**
     * Accesses the {@code invoice} and determines the value referenced by {@code ref} and the given {@code lineNumber}.
     * Returns {@link Optional#empty()} if the value or one of its parents is null.
     *
     * @param ref the reference to the field on the line item.
     * @param invoice the root object on which the reference gets applied
     * @param lineId the accessor needs to know for which line exactly the value should be returned
     * @return an Optional containing the value or {@link Optional#empty()} if no value has been found.
     */
    public <T> Optional<T> getOptionalValue( InvoiceReference ref, Invoice invoice, String lineId ) {
        return getValueForReference( ref, invoice, lineId );
    }

    /**
     * Accesses the {@code invoice} and determines the value referenced by {@code ref} and the given {@code lineNumber}.
     *
     * @param ref the reference to the field on the line item.
     * @param invoice the root object on which the reference gets applied
     * @param lineId the accessor needs to know for which line exactly the value should be returned
     * @return the value or {@link Optional#empty()} if no value has been found.
     * @throws MissingInvoiceValueException if the value or one of its parents is null
     */
    public <T> T getRequiredValue( InvoiceReference ref, Invoice invoice, String lineId )
        throws MissingInvoiceValueException {
        Optional<T> value = getValueForReference( ref, invoice, lineId );
        if ( !value.isPresent() ) {
            throw new MissingInvoiceValueException( ref, invoice, lineId );
        }
        return value.get();
    }

    @SuppressWarnings( "unchecked" )
    private <T> Optional<T> getValueForReference( InvoiceReference ref, Invoice invoice, String lineId ) {
        try {
            Object expression = Ognl.parseExpression( ref.getQueryPath() );
            if ( ref instanceof LineReference && lineId == null ) {
                throw new IllegalArgumentException( "LineReference expects the line number as additional argument!" );
            }

            Map<String, Object> additionalArgs = Collections.singletonMap( LineReference.LINE_NUMBER_ARG_NAME, lineId );

            Object ognlResult = Ognl.getValue( expression, additionalArgs, invoice );
            if ( ognlResult instanceof Optional ) {
                return (Optional<T>) ognlResult;
            }
            return Optional.ofNullable( (T) ognlResult );
        }
        catch ( OgnlException e ) {
            if ( e instanceof NoSuchPropertyException ) {
                throw new IllegalArgumentException(
                    String.format( "Invalid queryPath (%s) for invoice reference '%s'!", ref.getQueryPath(),
                            ref.getDisplayName() ), e );
            }
            return Optional.empty();
        }
    }

}
