package com.intellivat.domain.invoice;

import javax.xml.bind.annotation.XmlType;

import com.google.common.base.Objects;
import com.intellivat.domain.invoice.schema.PretaxChainTransaction;

/**
 * An invoice may be part of a so-called "invoice chain", i.e. several invoices belonging to the same transaction. In
 * such cases it is necessary to provide transaction related information for the decision logic, which must be provided
 * by the source system.
 * 
 * @author Alexander Niemann
 */
// This needs to be changed as soon as we define the schema for PostTaxInvoice!
@XmlType( namespace = "http://intellivat.com/invoice/pretax" )
public class ChainTransaction {

    private boolean isImport;

    private boolean isExport;

    private boolean isImported;

    private boolean isExported;

    /**
     * Sets all flags to {@code false}.
     */
    public ChainTransaction() {
        this.isImport = false;
        this.isExport = false;
        this.isImported = false;
        this.isExported = false;
    }

    public ChainTransaction( boolean isImport, boolean isExport, boolean isImported, boolean isExported ) {
        this.isImport = isImport;
        this.isExport = isExport;
        this.isImported = isImported;
        this.isExported = isExported;
    }

    /**
     * Copy constructor.
     * 
     * @param toCopy
     */
    public ChainTransaction( ChainTransaction toCopy ) {
        if ( toCopy != null ) {
            this.isImport = toCopy.isImport;
            this.isExport = toCopy.isExport;
            this.isImported = toCopy.isImported;
            this.isExported = toCopy.isExported;
        }
    }

    public ChainTransaction( PretaxChainTransaction pretaxChainTransaction){
        this(pretaxChainTransaction != null ? pretaxChainTransaction.isImport() : false,
            pretaxChainTransaction != null ? pretaxChainTransaction.isExport() : false,
            pretaxChainTransaction != null ? pretaxChainTransaction.isImported() : false,
            pretaxChainTransaction != null ? pretaxChainTransaction.isExported() : false);
    }

    public boolean isImport() {
        return isImport;
    }

    public void setImport( boolean isImport ) {
        this.isImport = isImport;
    }

    public boolean isExport() {
        return isExport;
    }

    public void setExport( boolean isExport ) {
        this.isExport = isExport;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported( boolean isImported ) {
        this.isImported = isImported;
    }

    public boolean isExported() {
        return isExported;
    }

    public void setExported( boolean isExported ) {
        this.isExported = isExported;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode( isExport, isExported, isImport, isImported );
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        ChainTransaction other = (ChainTransaction) obj;
        return Objects.equal( this.isExport, other.isExport )
            && Objects.equal( this.isExported, other.isExported )
            && Objects.equal( this.isImport, other.isImport )
            && Objects.equal( this.isImported, other.isImported );
    }

}
