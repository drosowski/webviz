package com.intellivat.domain.masterdata;

/**
 * This interface describes operations to manipulate TDIS Data.
 */
public interface TaxDataUpdater {

    SnapshotToken updateDatabase( String updateData );

    SnapshotToken resetDatabaseTo( SnapshotToken snapshotToken );

}
