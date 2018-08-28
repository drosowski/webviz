package com.intellivat.domain.invoice.taxationresult;

import com.intellivat.domain.masterdata.LocationLevel;

import java.util.EnumMap;
import java.util.Map;

public class TaxDecisionResultMap
                extends EnumMap<LocationLevel, TaxDecisionResult> {
    public TaxDecisionResultMap() {
        super( LocationLevel.class );
    }

    public TaxDecisionResultMap( Map<LocationLevel, ? extends TaxDecisionResult> m ) {
        super( m );
    }
}
