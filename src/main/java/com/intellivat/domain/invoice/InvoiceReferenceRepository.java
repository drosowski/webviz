package com.intellivat.domain.invoice;

import java.util.Set;

/**
 * A repository that stores and loads {@link InvoiceReference}s. During development this is usually a static
 * implementation without any real database.
 *
 * @author Daniel Rosowski
 */
public interface InvoiceReferenceRepository {

    InvoiceReference getInvoiceReferenceFor( String id );

    void storeInvoiceReference( String id, InvoiceReference invoiceReference );

    Set<InvoiceReference> getAllInvoiceReferencesForType( Class<?> invoiceRefernceType );
}
