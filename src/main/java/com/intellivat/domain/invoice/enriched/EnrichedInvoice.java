package com.intellivat.domain.invoice.enriched;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.intellivat.domain.invoice.schema.PreTaxInvoice;
import com.intellivat.domain.invoice.DocumentInfo;
import com.intellivat.domain.invoice.Invoice;
import com.intellivat.domain.masterdata.SnapshotToken;

/**
 * The enriched invoice contains all fields found in the {@code PreTaxInvoice}, plus the data which is added during the
 * preprocessing of the incoming {@code PreTaxInvoice}. The {@code EnrichedInvoice} is then used for the evaluation of
 * the {@code TaxDecisionTree}.
 * 
 * @author Daniel Rosowski
 */
public class EnrichedInvoice
    implements Invoice {

    private DocumentInfo documentInfo = new DocumentInfo();

    private EnrichedHeader header = new EnrichedHeader();

    private List<EnrichedLine> lines = new ArrayList<>();

    private PreTaxInvoice preTaxInvoice;

    private SnapshotToken snapshotToken = null;

    /**
     * The most likely tax point (date) when the transaction is taxable. This can either be
     * <ol>
     * <li>the {@link EnrichedHeader#getReferenceDate() reference data}</li>
     * <li>a date setting for the seller country</li>
     * <li>or the tax point default setting defined in the {@link EnrichedHeader#getInvoiceDate() invoice date}</li>
     * </ol>
     */
    private LocalDate taxPointDate;

    /**
     * Default constructor for de/serialization
     */
    EnrichedInvoice() {
    }

    public EnrichedInvoice( PreTaxInvoice baseInvoice, DocumentInfo documentInfo, EnrichedHeader header,  List<EnrichedLine> lines ) {
        if ( baseInvoice != null ) {
            this.preTaxInvoice = baseInvoice;
            this.documentInfo = documentInfo;
            this.header = header;
            this.lines = lines;
        }
    }

    public DocumentInfo getDocumentInfo() {
        return documentInfo;
    }

    public void setDocumentInfo( DocumentInfo documentInfo ) {
        this.documentInfo = documentInfo;
    }

    public EnrichedHeader getHeader() {
        return header;
    }

    public void setHeader( EnrichedHeader header ) {
        this.header = header;
    }

    public List<EnrichedLine> getLines() {
        return lines;
    }

    public void setLines( List<EnrichedLine> lines ) {
        this.lines = lines;
    }

    public void addLine( EnrichedLine line ) {
        lines.add( line );
    }

    public LocalDate getTaxPointDate() {
        return taxPointDate;
    }

    public void setTaxPointDate( LocalDate taxPointDate ) {
        this.taxPointDate = taxPointDate;
    }

    public PreTaxInvoice getPreTaxInvoice() {
        return preTaxInvoice;
    }

    public void setPreTaxInvoice( PreTaxInvoice preTaxInvoice ) {
        this.preTaxInvoice = preTaxInvoice;
    }

    public SnapshotToken getSnapshotToken() {
        return snapshotToken;
    }

    public void setSnapshotToken(SnapshotToken snapshotToken) {
        this.snapshotToken = snapshotToken;
    }

    /**
     * @param lineId
     * @return the line for {@code lineNumber} or null
     * @throws IllegalStateException if more than one line matches {@code lineNumber}
     */
    public EnrichedLine getLine( String lineId ) {
        List<EnrichedLine> filtered = lines.stream()
            .filter( line -> line.getLineId().equals(lineId ))
            .collect( Collectors.toList() );

        if ( filtered.isEmpty() ) {
            return null;
        }

        if ( filtered.size() > 1 ) {
            throw new IllegalStateException( String.format( "There is more than one line with line id %s!", lineId ) );
        }

        return filtered.get( 0 );
    }

    public final static class Builder {

        private EnrichedInvoice instance;

        private Builder() {}

        public static Builder create( String id ) {
            Builder builder = new Builder();
            builder.instance = new EnrichedInvoice();
            return builder;
        }

        public Builder withDocumentInfo( DocumentInfo documentInfo ) {
            this.instance.setDocumentInfo( documentInfo );
            return this;
        }

        public Builder withHeader( EnrichedHeader header ) {
            this.instance.setHeader( header );
            return this;
        }

        public Builder withLines( List<EnrichedLine> lines ) {
            this.instance.setLines( lines );
            return this;
        }

        public Builder withLines( EnrichedLine... lines ) {
            this.instance.setLines( Arrays.asList( lines ) );
            return this;
        }

        public EnrichedInvoice build() {
            return instance;
        }
    }
}
