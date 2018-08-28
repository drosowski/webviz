package com.intellivat.domain.calculation;

import java.time.Instant;
import java.time.LocalDate;

import com.intellivat.domain.taxtree.TaxDecisionTree;

public class TreeValidation {

    private TaxDecisionTree taxDecisionTree;

    private LocalDate validOn;

    public TreeValidation() {

    }

    public TreeValidation( TaxDecisionTree taxDecisionTree, LocalDate validOn ) {
        this.taxDecisionTree = taxDecisionTree;
        this.validOn = validOn;
    }

    public TaxDecisionTree getTaxDecisionTree() {
        return taxDecisionTree;
    }

    public void setTaxDecisionTree( TaxDecisionTree taxDecisionTree ) {
        this.taxDecisionTree = taxDecisionTree;
    }

    public LocalDate getValidOn() {
        return validOn;
    }

    public void setValidOn( LocalDate validOn ) {
        this.validOn = validOn;
    }

}
