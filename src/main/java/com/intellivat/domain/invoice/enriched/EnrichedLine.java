package com.intellivat.domain.invoice.enriched;

import com.google.common.base.Preconditions;
import com.intellivat.domain.Amount;
import com.intellivat.domain.invoice.schema.MainLine;
import com.intellivat.domain.masterdata.Unspsc;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * A single line on an invoice, usually representing a good or a service.
 * 
 * @author Daniel Rosowski
 * @author Alex Rommel
 */
public class EnrichedLine {

    private int sortIndex;

    private String lineId;

    private Unspsc unspsc;

    private Amount amount;

    private MainLine preTaxLine;

    private EnrichedTransactionContext transactionContext;

    /**
     * Private no-arg constructor is just to keep JAXB from complaining
     */
    @SuppressWarnings( "unused" )
    private EnrichedLine() {}

    public EnrichedLine( int sortIndex, MainLine line, EnrichedTransactionContext transactionContext ) {
        Preconditions.checkNotNull(line);
        Preconditions.checkNotNull( transactionContext );
        setInformationFromPreTax(line);
        this.transactionContext = transactionContext;
        this.sortIndex = sortIndex;
    }

    private void setInformationFromPreTax(MainLine line) {
        this.preTaxLine = line;
        if (line != null) {
            this.lineId = line.getId();
            this.amount = Amount.valueOf( line.getQuantity() ).multiply( Amount.valueOf( line.getUnitPrice() ) );
        }
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount( Amount amount ) {
        this.amount = amount;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId( String lineId) {
        this.lineId = lineId;
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex( int sortIndex ) {
        this.sortIndex = sortIndex;
    }

    public Unspsc getUnspsc() {
        return unspsc;
    }

    public void setUnspsc( Unspsc unspsc ) {
        this.unspsc = unspsc;
    }

    public MainLine getPreTaxLine() {
        return preTaxLine;
    }

    public void setPreTaxLine( MainLine preTaxLine ) {
        setInformationFromPreTax(preTaxLine);
    }

    public EnrichedTransactionContext getTransactionContext() {
        return transactionContext;
    }

    private void setTransactionContext(EnrichedTransactionContext transactionContext) {
        this.transactionContext =  transactionContext;
    }

    @Override
    public String toString() {
        return lineId + ":" + lineId;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }

        final EnrichedLine other = (EnrichedLine) obj;
        return Objects.equals( this.lineId, other.lineId );
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lineId);
    }

    //TODO: Make EnrichedLine immutable and get rid of this builder
    public static final class Builder {

        private EnrichedLine instance;

        private Builder() {}

        public static Builder create( int sortIndex, String lineId ) {
            Builder builder = new Builder();
            builder.instance = new EnrichedLine( );
            builder.instance.setLineId( lineId );
            builder.instance.setSortIndex( sortIndex );
            MainLine mainLine = new MainLine();
            mainLine.setId( lineId );
            mainLine.setQuantity( BigDecimal.ONE );
            mainLine.setUnitPrice( BigDecimal.ONE );
            builder.instance.setPreTaxLine( mainLine );
            return builder;
        }

        public Builder withUnspsc( Unspsc unspscForDecision ) {
            this.instance.setUnspsc( unspscForDecision );
            return this;
        }

        public Builder withNetAmount( Amount netAmount ) {
            this.instance.setAmount( netAmount );
            this.instance.getPreTaxLine().setUnitPrice( netAmount.getValue() );
            return this;
        }

        public Builder withTransactionContext( EnrichedTransactionContext transactionContext ) {
            this.instance.setTransactionContext( transactionContext );
            return this;
        }

        public EnrichedLine build() {
            return instance;
        }
    }

}
