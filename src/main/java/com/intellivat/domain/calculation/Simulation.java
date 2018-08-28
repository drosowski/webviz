package com.intellivat.domain.calculation;

import com.intellivat.domain.taxtree.TaxDecisionTree;

import java.util.Arrays;

/**
 * A simulation contains a {@code taxTree} and an {@code invoice} and can be used to run a simulation of the evaluation
 * and calculation using the processing engine.
 * 
 * @author Daniel Rosowski
 */
public class Simulation {

    private TaxDecisionTree taxDecisionTree;

    private byte[] preTaxInvoice;

    public Simulation() {}

    public Simulation( TaxDecisionTree taxDecisionTree, byte[] preTaxInvoice ) {
        this.taxDecisionTree = taxDecisionTree;
        if ( preTaxInvoice == null ) {
            this.preTaxInvoice = new byte[0];
        } else {
            this.preTaxInvoice = Arrays.copyOf( preTaxInvoice, preTaxInvoice.length );
        }
        this.preTaxInvoice = preTaxInvoice;
    }

    public TaxDecisionTree getTaxDecisionTree() {
        return taxDecisionTree;
    }

    public void setTaxDecisionTree( TaxDecisionTree taxDecisionTree ) {
        this.taxDecisionTree = taxDecisionTree;
    }

    public byte[] getPreTaxInvoice() {
        return preTaxInvoice;
    }

    public void setPreTaxInvoice( byte[] preTaxInvoice ) {
        if ( preTaxInvoice == null ) {
            this.preTaxInvoice = new byte[0];
        } else {
            this.preTaxInvoice = Arrays.copyOf( preTaxInvoice, preTaxInvoice.length );
        }
    }

}
