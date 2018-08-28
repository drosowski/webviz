package com.intellivat.domain.masterdata;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * Provides tax data to clients, such as {@link TaxRate}s.
 * </p>
 * <p>
 * Every Method takes a {@code taxPoint} and a {@code snapshotToken} to specify the tax relevant date and processing
 * timestamp the queried information is relevant for.
 * </p>
 * <p>
 * Every operation in this interface can be considered idempotent so that every call with the same arguments always
 * returns the same answer. This makes it possible to cache these operations
 * </p>
 */
public interface TaxDataProvider {

    /**
     * Returns the TaxRate for the given Unspsc and Jurisdiction. Moves up in the hierarchical Unspsc structure if there
     * is no entry for the requested unspsc. The TaxRate is Jurisdiction specific for a TaxRateIndicator which can be
     * found in a UnspscCatalogEntry for the given Jurisdiction and Unspsc. If there is no matching UnspscCatalogEntry
     * the lookup is repeated the the given Unspsc's parent unless this would be the parent of the Root Unspsc. In this
     * case the procedure is cancelled.
     * 
     * @return A tuple of the requested tax rate and the unspsc that has been used to look up the tax rate. The returned
     *         unspsc differs from the given unspsc in case that the hierarchical lookup has been used.<br>
     *         The returned optional is empty...
     *         <ul>
     *         <li>...if there is no valid registered association ({@link UnspscCatalogEntry}) between the given
     *         jurisdiction and unspsc (and it's parent unspscs)</li>
     *         <li>...if there is no tax rate for the determined tax rate indicator at the jurisdiction</li>
     *         </ul>
     */
    Optional<TaxRateAndUnspsc> findTaxRateAndClosestRegisteredUnspsc(Unspsc unspscToQuery, Jurisdiction jurisdiction,
                                                                             LocalDate taxPoint, SnapshotToken token );

    /**
     * Finds a TaxRate for the given Jurisdiction and the given TaxRateIndicatorKey.
     * 
     * @return The returned optional is empty if no matching TaxRate has been found.
     */
    Optional<TaxRate> findTaxRateByJurisdictionAndTaxRateIndicatorKey( Jurisdiction jurisdiction, String taxRateIndicatorKey,
                                                                       LocalDate taxPoint, SnapshotToken token );

    /**
     * Find TaxIndicatorComments for a given TaxIndicator
     *
     * @return
     */
    List<TaxIndicatorComment> findCommentForTaxIndicator( TaxIndicator taxIndicator,
                                                          LocalDate taxPoint, SnapshotToken token );
}
