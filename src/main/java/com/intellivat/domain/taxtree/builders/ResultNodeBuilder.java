package com.intellivat.domain.taxtree.builders;

import com.google.common.base.Preconditions;
import com.intellivat.domain.invoice.InvoiceReference;
import com.intellivat.domain.masterdata.LocationLevel;
import com.intellivat.domain.masterdata.MasterdataReference;
import com.intellivat.domain.masterdata.TaxIndicator;
import com.intellivat.domain.taxtree.Result;
import com.intellivat.domain.taxtree.ResultNode;

/**
 * Builder for {@link ResultNode}s. Use the {@link NodeFactory}!
 *
 * @author Daniel Rosowski
 */
public class ResultNodeBuilder {
    private ResultNode instance = new ResultNode();

    public ResultNodeBuilder withCountryLevelResult( Result result ) {
        instance.setResult( LocationLevel.COUNTRY, result );
        return this;
    }

    public ResultNodeBuilder withCountryLevelResult( String taxIndicatorKey,
                                                     InvoiceReference sellerGeoArea,
                                                     InvoiceReference buyerGeoArea ) {
        Preconditions.checkNotNull(sellerGeoArea.getType());
        Preconditions.checkNotNull(buyerGeoArea.getType());
        MasterdataReference taxIndicatorRef = new MasterdataReference(taxIndicatorKey, TaxIndicator.class);
        instance.setResult( LocationLevel.COUNTRY, new Result( taxIndicatorRef, sellerGeoArea, buyerGeoArea ) );
        return this;
    }



    public ResultNode build() {
        return instance;
    }
}
