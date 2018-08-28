package com.intellivat.domain.masterdata;

/**
 * This interfaces describes methods to query for processing time tokens.
 */
public interface ProcessingTimeManager {

    /**
     * Returns the processing time token for the current state of TDIS data.
     * @return processing time token
     */
    SnapshotToken retrieveLatestSnapshot();

}
