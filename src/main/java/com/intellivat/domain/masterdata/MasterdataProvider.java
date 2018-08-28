package com.intellivat.domain.masterdata;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * Provides {@link Masterdata} and {@link MasterdataReference}s to clients.
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
public interface MasterdataProvider {

    /**
     * Returns a List of jurisdictions that are relevant for the given Location.
     */
    List<Jurisdiction> findJurisdictionsByLocation( Location location, LocalDate taxPoint, SnapshotToken snapshotToken );

    /**
     * Gets all MasterdataReferences for a specified Masterdata class.
     */
    List<MasterdataReference> findAllMasterdataReferencesForType( Class<? extends Masterdata> type, LocalDate taxPoint,
                                                                  SnapshotToken snapshotToken );

    /**
     * Gets a specific Masterdata described by a masterdataReference.
     */
    Optional<Masterdata> findMasterdata( MasterdataReference masterdataReference, LocalDate taxPoint,
                                         SnapshotToken snapshotToken );
}
