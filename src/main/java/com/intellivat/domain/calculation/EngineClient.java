package com.intellivat.domain.calculation;

import com.intellivat.domain.invoice.schema.OutputTaxationResult;
import com.intellivat.domain.invoice.taxationresult.TaxationResult;
import com.intellivat.domain.taxtree.TaxDecisionTree;

/**
 * A client for the REST API of IntelliVATs engine.
 *
 */
public interface EngineClient {

    TaxationResult simulateCalculation( TaxDecisionTree taxDecisionTree, byte[] preTaxInvoice );

    /**
     * Given a preTaxInvoioce XML as an byte array, it returns an {@link OutputTaxationResult} as an byte array.
     */
    byte[] calculateInvoice( byte[] preTaxInvoice );
}
