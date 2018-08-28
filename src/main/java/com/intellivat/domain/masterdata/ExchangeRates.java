package com.intellivat.domain.masterdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

/**
 * Holds all exchange rates for one anchor currency so all rates represent an exchange from anchor currency to target currency.
 */
@ViewableFields("rates")
public class ExchangeRates
        implements Masterdata {

    private final String anchorCurrencyCode;

    private final Map<String, BigDecimal> rates;

    @JsonCreator
    public ExchangeRates(@JsonProperty("anchorCurrencyCode") String anchorCurrencyCode,
                         @JsonProperty("rates") Map<String, BigDecimal> rates) {
        this.anchorCurrencyCode = anchorCurrencyCode;
        this.rates = rates;
    }

    public String getAnchorCurrencyCode() {
        return anchorCurrencyCode;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    @JsonIgnore
    public BigDecimal getRate(String currencyCode) {
        return rates.get(currencyCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ExchangeRates that = (ExchangeRates) o;

        if (!rates.equals(that.rates))
            return false;
        if (!anchorCurrencyCode.equals(that.anchorCurrencyCode))
            return false;

        return true;
    }

    @Override
    public String masterdataKey() {
        return anchorCurrencyCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anchorCurrencyCode, rates);
    }

}
