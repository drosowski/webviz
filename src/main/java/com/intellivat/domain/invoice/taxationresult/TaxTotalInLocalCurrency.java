package com.intellivat.domain.invoice.taxationresult;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intellivat.domain.Amount;

/**
 * Created by timo on 27.08.15.
 */
public class TaxTotalInLocalCurrency {

    protected final String localCurrencyCode;

    protected final Amount exchangeRate;

    protected final Amount amount;

    @JsonCreator
    public TaxTotalInLocalCurrency( @JsonProperty( "localCurrencyCode" ) String localCurrencyCode,
                                    @JsonProperty( "exchangeRate" ) Amount exchangeRate,
                                    @JsonProperty( "amount" ) Amount amount ) {
        this.localCurrencyCode = localCurrencyCode;
        this.exchangeRate = exchangeRate;
        this.amount = amount;
    }

    public String getLocalCurrencyCode() {
        return localCurrencyCode;
    }

    public Amount getExchangeRate() {
        return exchangeRate;
    }

    public Amount getAmount() {
        return amount;
    }
}
