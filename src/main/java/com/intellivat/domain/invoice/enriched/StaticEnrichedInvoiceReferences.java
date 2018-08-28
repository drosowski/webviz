package com.intellivat.domain.invoice.enriched;

import com.intellivat.domain.invoice.ChainTransaction;
import com.intellivat.domain.invoice.InvoiceReference;
import com.intellivat.domain.invoice.StaticInvoiceReference;
import com.intellivat.domain.invoice.StaticLineReference;
import com.intellivat.domain.invoice.schema.TransactionContext;
import com.intellivat.domain.masterdata.Company;
import com.intellivat.domain.masterdata.Location;
import com.intellivat.domain.masterdata.Unspsc;
import com.intellivat.domain.rules.ContextEntry;
import com.intellivat.domain.rules.SimpleParameter;

import java.time.LocalDate;
import java.util.Set;

public enum StaticEnrichedInvoiceReferences {

    SELLER( "Seller", "header.seller", Company.class, StaticInvoiceReference.class ),
    SELLER_LOCATION( "Seller Location", "header.seller.address", Location.class, StaticInvoiceReference.class ),
    BUYER( "Buyer", "header.buyer", Company.class, StaticInvoiceReference.class ),
    BUYER_LOCATION( "Buyer Location", "header.buyer.address", Location.class, StaticInvoiceReference.class ),
    RECEIVER_LOCATION( "Receiver Location", "getLine(#lineNumber).transactionContext.receiverLocation", Location.class,
                    StaticLineReference.class ),
    SENDER_LOCATION( "Sender Location", "getLine(#lineNumber).transactionContext.senderLocation", Location.class,
                    StaticLineReference.class ),
    SERVICE_PROVIDER_LOCATION( "Service Provider Location", "getLine(#lineNumber).transactionContext.serviceProviderLocation",
                    Location.class,
                    StaticLineReference.class ),
    SHIP_TO_LOCATION( "Ship To Location", "getLine(#lineNumber).transactionContext.shipment.shipTo", Location.class,
                    StaticLineReference.class ),
    SHIP_FROM_LOCATION( "Ship From Location", "getLine(#lineNumber).transactionContext.shipment.shipFrom", Location.class,
                    StaticLineReference.class ),
    CHAIN_TRANSACTION( "Chain Transaction", "getLine(#lineNumber).transactionContext.chainTransaction", ChainTransaction.class,
                    StaticLineReference.class ),
    SELLER_TAX_REGISTRATIONS( "Seller Tax Registrations", "header.seller.taxRegistrations", Set.class,
        StaticInvoiceReference.class ),
    BUYER_TAX_REGISTRATIONS( "Buyer Tax Registrations", "header.buyer.taxRegistrations", Set.class,
        StaticInvoiceReference.class ),
    SERVICE_RENDERED_LOCATION( "Service Rendered Location", "getLine(#lineNumber).transactionContext.serviceRenderedArea", Location.class,
                    StaticLineReference.class ),
    TAX_POINT( "Tax Point date", "taxPointDate", LocalDate.class, StaticInvoiceReference.class ),
    LINE_CHAIN_TRANSACTION( "Line Chain Transaction", "getLine(#lineNumber).transactionContext.chainTransaction",
        ChainTransaction.class, StaticLineReference.class ),
    TRANSACTION_CONTEXT( "Business Type", "getLine(#lineNumber).transactionContext", TransactionContext.class,
                    StaticLineReference.class ),
    ITEM_UNSPSC( "Item UNSPSC", "getLine(#lineNumber).unspsc", Unspsc.class, StaticLineReference.class );

    private final InvoiceReference invoiceReference;

    private final ContextEntry contextEntry;

    /**
     * Utilizes the {@link com.intellivat.domain.invoice.InvoiceReference.Builder} to create the underlying invoice
     * reference for this enum.
     *
     * @param queryPath
     */
    StaticEnrichedInvoiceReferences( String displayName, String queryPath, Class<?> type, Class<? extends InvoiceReference> refType ) {
        this.invoiceReference = InvoiceReference.Builder
            .newInvoiceReference( displayName, refType )
            .withQueryPath( queryPath )
            .withType( type )
            .build();
        this.contextEntry = new ContextEntry( new SimpleParameter( this.name() ), invoiceReference );
    }

    public InvoiceReference reference() {
        return invoiceReference;
    }

    public ContextEntry contextEntry() {
        return contextEntry;
    }
}
