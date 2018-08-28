package com.intellivat.domain.taxtree;

import com.intellivat.domain.masterdata.SnapshotToken;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Manager interface for the {@link TaxDecisionTree}.
 * 
 * @author Daniel Rosowski
 */
public interface TaxDecisionTreeManager {

    /**
     * @return an instance of the {@code TaxDecisionTree} that is/was active for the given {@code date}.
     */
    Optional<TaxDecisionTree> getTaxTreeForDate( LocalDate taxPoint, SnapshotToken snapshotToken );

    /**
     * Activates the given {@link TaxDecisionTree} for the given activationDate.
     * 
     * @param treeToActivate a validated tree, which shall be activated
     * @param activationDate the date on which the tree shall become valid
     */
    void activateTaxDecisionTree( TaxDecisionTree treeToActivate, LocalDate activationDate );

    /**
     * Validates tax decision tree for a given date.
     *
     * @param taxDecisionTree
     * @param taxPoint
     * @param snapshotToken
     * @return validation result
     */
    TreeValidationResult validateTaxDecisionTree( TaxDecisionTree taxDecisionTree, LocalDate taxPoint, SnapshotToken snapshotToken );

    /**
     * @return a List of {@link TaxTreeReference}s, The Reference can be used to load a certain tree from tdis.
     */
    List<TaxTreeReference> getAllTaxTreeReferences();

}