package com.intellivat.domain.invoice.enriched;

import com.intellivat.domain.masterdata.Company;
import com.intellivat.domain.masterdata.Currency;
import com.intellivat.domain.masterdata.PriceType;

import java.time.LocalDate;

import java.time.LocalDate;
import java.util.Locale;

/**
 * The header includes data for the invoice itself, e.g. seller, buyer, invoice date, payment date, invoice language.
 * 
 * @author Alex Rommel
 */
public class EnrichedHeader {

    private LocalDate invoiceDate;

    private LocalDate paymentDate;

    private LocalDate orderDate;

    private LocalDate referenceDate;

    private Locale invoiceLanguage;

    private Currency currency;

    private PriceType priceType;

    private boolean resalePurpose;

    private Company seller;

    private Company buyer;

    private EnrichedTransactionContext transactionContext = new EnrichedTransactionContext();

    /**
     * Copy constructor
     */
    public EnrichedHeader( EnrichedHeader header ) {
        if ( header != null ) {
            this.invoiceDate = header.invoiceDate;
            this.paymentDate = header.paymentDate;
            this.orderDate = header.orderDate;
            this.referenceDate = header.referenceDate;
            this.invoiceLanguage = header.invoiceLanguage;
            this.currency = header.currency;
            this.priceType = header.priceType;
            this.resalePurpose = header.resalePurpose;
            this.seller =  header.seller;
            this.buyer = header.buyer;
            this.transactionContext = new EnrichedTransactionContext( header.transactionContext );
        }
    }

    /**
     * Default constructor
     */
    EnrichedHeader() {}

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate( LocalDate invoiceDate ) {
        this.invoiceDate = invoiceDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate( LocalDate paymentDate ) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate( LocalDate orderDate ) {
        this.orderDate = orderDate;
    }

    public LocalDate getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate( LocalDate referenceDate ) {
        this.referenceDate = referenceDate;
    }

    public Locale getInvoiceLanguage() {
        return invoiceLanguage;
    }

    public void setInvoiceLanguage( Locale invoiceLanguage ) {
        this.invoiceLanguage = invoiceLanguage;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency( Currency currency ) {
        this.currency = currency;
    }

    public PriceType getPriceType() {
        return priceType;
    }

    public void setPriceType( PriceType priceType ) {
        this.priceType = priceType;
    }

    public boolean isResalePurpose() {
        return resalePurpose;
    }

    public void setResalePurpose( boolean resalePurpose ) {
        this.resalePurpose = resalePurpose;
    }

    public Company getSeller() {
        return seller;
    }

    public void setSeller( Company seller ) {
        this.seller = seller;
    }

    public Company getBuyer() {
        return buyer;
    }

    public void setBuyer( Company buyer ) {
        this.buyer = buyer;
    }

    public EnrichedTransactionContext getTransactionContext() {
        return transactionContext;
    }

    public void setTransactionContext( EnrichedTransactionContext transactionContext ) {
        this.transactionContext = transactionContext;
    }

    public final static class Builder {

        private EnrichedHeader instance;

        private Builder() {}

        public static Builder create() {
            Builder builder = new Builder();
            builder.instance = new EnrichedHeader();
            return builder;
        }

        public Builder withInvoiceDate( LocalDate invoiceDate ) {
            this.instance.setInvoiceDate( invoiceDate );
            return this;
        }

        public Builder withPaymentDate( LocalDate paymentDate ) {
            this.instance.setPaymentDate( paymentDate );
            return this;
        }

        public Builder withOrderDate( LocalDate orderDate ) {
            this.instance.setOrderDate( orderDate );
            return this;
        }

        public Builder withReferenceDate( LocalDate referenceDate ) {
            this.instance.setReferenceDate( referenceDate );
            return this;
        }

        public Builder withInvoiceLanguage( Locale invoiceLanguage ) {
            this.instance.setInvoiceLanguage( invoiceLanguage );
            return this;
        }

        public Builder withCurrency( Currency currency ) {
            this.instance.setCurrency( currency );
            return this;
        }

        public Builder withPriceType( PriceType priceType ) {
            this.instance.setPriceType( priceType );
            return this;
        }

        public Builder withResalePurpose( boolean resalePurpose ) {
            this.instance.setResalePurpose( resalePurpose );
            return this;
        }

        public Builder withSeller( Company seller ) {
            this.instance.setSeller( seller );
            return this;
        }

        public Builder withBuyer( Company buyer ) {
            this.instance.setBuyer( buyer );
            return this;
        }

        public Builder withTransactionContext( EnrichedTransactionContext transactionContext ) {
            this.instance.setTransactionContext( transactionContext );
            return this;
        }

        public EnrichedHeader build() {
            return instance;
        }
    }

}
