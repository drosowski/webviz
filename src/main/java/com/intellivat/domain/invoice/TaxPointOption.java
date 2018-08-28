package com.intellivat.domain.invoice;



/**
 * This enumeration contains the various possible {@code TaxPoint}s a {@link com.intellivat.domain.masterdata.Jurisdiction} can be configured to use.
 * E.g. one jurisdiction may require the payment date as the tax point, another one may require the deliver date.
 * 
 * @author Daniel Rosowski
 */
public enum TaxPointOption {

    INVOICE_DATE( "header.invoiceDate" );

    private InvoiceReference invoiceReference;

    TaxPointOption( String queryPath ) {
        this.invoiceReference = InvoiceReference.Builder
            .newInvoiceReference( this.name(), StaticInvoiceReference.class )
            .withQueryPath( queryPath ).build();
    }

    /**
     * @return a reference to the date field in the invoice, that this tax point refers to.
     */
    public InvoiceReference getInvoiceReference() {
        return invoiceReference;
    }
}
