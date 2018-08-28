package com.intellivat.domain.invoice;


/**
 * An exception that gets thrown if a required invoice value is missing.
 * 
 * @author Daniel Rosowski
 */
public class MissingInvoiceValueException
    extends RuntimeException {

    private static final long serialVersionUID = 4400161150607973398L;

    public MissingInvoiceValueException( InvoiceReference ref, Invoice invoice ) {
        this( ref, invoice, null );
    }

    public MissingInvoiceValueException( InvoiceReference ref, Invoice invoice, String lineId ) {
        super( String.format( "Required value for reference '%s' is missing from invoice on line %s!",
            ref.getDisplayName(), lineId ) );
    }
}
