package com.intellivat.domain.invoice.enriched;

import com.intellivat.domain.invoice.schema.PreTaxInvoice;

/**
 * Preprocesses an incoming {@link PreTaxInvoice}, during which the provided value objects (e.g. Locations and
 * companies) are being replaced by the matching entities fetched from the database. Additionally the
 * {@link EnrichedInvoice#getTaxPointDate() tax point date} is being determined.
 * 
 * @author Daniel Rosowski
 */
public interface InvoicePreprocessor {

    /**
     * <ul>
     * <li>Replace value objects in {@code invoice} with entities in the enriched invoice</li>
     * <li>Determine tax point date</li>
     * </ul>
     *
     * @param invoiceAsBytes PretaxInvoice as XML byte array
     * @return a result containing either the enriched invoice or a validation error.
     */
    InvoicePreprocessingResult preprocessPreTaxInvoice( byte[] invoiceAsBytes );

}
