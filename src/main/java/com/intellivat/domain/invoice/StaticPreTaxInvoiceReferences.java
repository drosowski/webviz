package com.intellivat.domain.invoice;

import com.intellivat.domain.invoice.InvoiceReference;
import com.intellivat.domain.invoice.StaticInvoiceReference;
import com.intellivat.domain.invoice.StaticLineReference;

public enum StaticPreTaxInvoiceReferences {

    PRE_TAX_RECEIVER( "Receiver", "header.transactionContext.receiverCompanyCustomId", String.class, StaticInvoiceReference.class ),
    PRE_TAX_SENDER( "Sender", "header.transactionContext.senderCompanyCustomId", String.class, StaticInvoiceReference.class ),
    PRE_TAX_SERVICE_PROVIDER( "Service Provider", "header.transactionContext.serviceProvicerCustomId", String.class,
            StaticInvoiceReference.class ),
    PRE_TAX_SELLER( "Seller", "header.sellerCompanyCustomId", String.class, StaticInvoiceReference.class ),
    PRE_TAX_BUYER( "Buyer", "header.buyerCompanyCustomId", String.class, StaticInvoiceReference.class ),
    PRE_TAX_SERVICE_RENDERED_AREA( "Service Rendered Area", "header.transactionContext.serviceRenderedArea", String.class,
        StaticInvoiceReference.class ),
    PRE_TAX_SHIP_FROM( "Ship from", "header.transactionContext.shipment.shipFrom", String.class, StaticInvoiceReference.class ),
    PRE_TAX_SHIP_TO( "Ship to", "header.transactionContext.shipment.shipTo", String.class, StaticInvoiceReference.class ),
    PRE_TAX_ITEM_UNSPSC( "Item UNSPSC", "getLine(#lineNumber).unspscCode", String.class, StaticLineReference.class );

    private final InvoiceReference invoiceReference;

    /**
     * Utilizes the {@link InvoiceReference.Builder} to create the underlying invoice reference for this enum.
     */
    StaticPreTaxInvoiceReferences( String displayName, String queryPath, Class<?> valueType, Class<? extends InvoiceReference> refType ) {
        this.invoiceReference = InvoiceReference.Builder
            .newInvoiceReference(displayName, refType )
            .withQueryPath( queryPath )
            .withType( valueType )
            .build();
    }

    public InvoiceReference reference() {
        return invoiceReference;
    }

}
