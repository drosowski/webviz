package com.intellivat.domain.invoice.taxationresult;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.intellivat.domain.Amount;
import com.intellivat.domain.masterdata.Currency;
import com.intellivat.domain.masterdata.*;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
public class PostTaxInvoice {

    private final EnumMap<LocationLevel, TaxDecisionResult> taxDecisionResults;

    private final List<InvoiceLine> invoiceLines;

    private final Map<TaxDecisionResult, Map<TaxRate, TaxCalculation>> taxTotals;

    private final TaxTotalInLocalCurrency taxTotalInLocalCurrency;

    private final Map<LocationLevel, TaxRegistrationResult> taxRegistrations;

    private final Map<LocationLevel, List<TaxIndicatorComment>> taxIndicatorComments;

    private final PriceType priceType;

    private PostTaxInvoice( List<InvoiceLine> invoiceLines,
                            EnumMap<LocationLevel, TaxDecisionResult> taxDecisionResults,
                            PriceType priceType) {
        this.taxDecisionResults = taxDecisionResults;
        this.invoiceLines = invoiceLines;
        this.taxTotalInLocalCurrency = null;
        this.taxRegistrations = ImmutableMap.of();
        this.taxIndicatorComments = ImmutableMap.of();
        this.priceType = priceType;
        taxTotals = initTotals();
    }

    @JsonCreator
    private PostTaxInvoice( @JsonProperty( "invoiceLines" ) List<InvoiceLine> invoiceLines,
                            @JsonProperty( "taxDecisionResults" ) EnumMap<LocationLevel, TaxDecisionResult> taxDecisionResults,
                            @JsonProperty( "taxRegistrations" ) Map<LocationLevel, TaxRegistrationResult> taxRegistrations,
                            @JsonProperty( "taxTotalInLocalCurrency" ) TaxTotalInLocalCurrency taxTotalInLocalCurrency,
                            @JsonProperty( "taxIndicatorComments" ) Map<LocationLevel, List<TaxIndicatorComment>> taxIndicatorComments,
                            @JsonProperty( "priceType" ) PriceType priceType ) {
        this.taxDecisionResults = taxDecisionResults;
        this.invoiceLines = invoiceLines;
        this.taxTotalInLocalCurrency = taxTotalInLocalCurrency;
        this.taxRegistrations = ImmutableMap.copyOf( taxRegistrations );
        this.taxIndicatorComments = taxIndicatorComments;
        this.priceType = priceType;
        taxTotals = initTotals();
    }

    public static PostTaxInvoice createPostTaxInvoice( List<InvoiceLine> invoiceLines,
                                                       TaxDecisionResult countryTaxDecisionResult ) {
        return createPostTaxInvoice(invoiceLines, countryTaxDecisionResult, null);
    }

    public static PostTaxInvoice createPostTaxInvoice( List<InvoiceLine> invoiceLines,
                                                       TaxDecisionResult countryTaxDecisionResult,
                                                       TaxDecisionResult stateTaxDecisionResult ) {

        return createPostTaxInvoice(invoiceLines, countryTaxDecisionResult, stateTaxDecisionResult, PriceType.NET);
    }

    public static PostTaxInvoice createPostTaxInvoice(List<InvoiceLine> invoiceLines,
                                                      TaxDecisionResult countryTaxDecisionResult,
                                                      TaxDecisionResult stateTaxDecisionResult,
                                                      PriceType priceType) {
        Preconditions.checkNotNull( countryTaxDecisionResult );
        Preconditions.checkArgument( countryTaxDecisionResult.getSellerJurisdiction().getLocationLevel() == LocationLevel.COUNTRY );

        EnumMap<LocationLevel, TaxDecisionResult> results = new EnumMap<>( LocationLevel.class );
        results.put( LocationLevel.COUNTRY, countryTaxDecisionResult );
        if ( stateTaxDecisionResult != null ) {
            results.put( LocationLevel.STATE, stateTaxDecisionResult );
        }
        return new PostTaxInvoice( invoiceLines, results, priceType );
    }

    private Map<TaxDecisionResult, Map<TaxRate, TaxCalculation>> initTotals() {

        Stream<Map.Entry<TaxDecisionResult, TaxCalculation>> entryStream = invoiceLines.stream()
                        .flatMap( l -> l.getTaxCalculations().entrySet().stream() )
                        .map( e -> new AbstractMap.SimpleEntry<>( e.getValue().getTaxDecisionResult(), e.getValue().getTaxCalculation() ) );

        Map<TaxDecisionResult, Map<TaxRate, TaxCalculation>> resultMapMap = entryStream
                        .collect( groupingBy(
                                                        entry -> entry.getKey(),
                                                        groupingBy( entry2 -> entry2.getValue().getTaxRate(),
                                                                        collectingAndThen(
                                                                                        reducing( reduceEntries() ),
                                                                                        entry -> scaledTaxCalculation( entry.get() )
                                                                        )
                                                        )
                                        )
                        );

        return resultMapMap;
    }

    private TaxCalculation scaledTaxCalculation( Map.Entry<TaxDecisionResult, TaxCalculation> entry ) {
        Jurisdiction jurisdiction = entry.getKey().getSellerJurisdiction();
        Currency currency = jurisdiction.getDefaultCurrency();
        TaxCalculation originalTaxCalculation = entry.getValue();

        Amount originalTaxAmount = originalTaxCalculation.getTaxAmount();
        Amount scaledTaxAmount = originalTaxAmount.setScale( currency.getFractionDigits(), currency.getRoundingMode() );

        Amount scaledBaseAmount;
        if(priceType == PriceType.GROSS_FIX) {
            scaledBaseAmount = originalTaxCalculation.getTotalAmount().subtract(scaledTaxAmount);
            scaledBaseAmount = scaledBaseAmount.setScale(currency.getFractionDigits(), currency.getRoundingMode());
        } else {
            Amount originalBaseAmount = originalTaxCalculation.getBaseAmount();
            scaledBaseAmount = originalBaseAmount.setScale(currency.getFractionDigits(), currency.getRoundingMode());
        }

        return new TaxCalculation(
                        scaledBaseAmount,
                        originalTaxCalculation.getTaxRate(),
                        scaledTaxAmount );
    }

    private BinaryOperator<Map.Entry<TaxDecisionResult, TaxCalculation>> reduceEntries() {
        return ( entry1, entry2 ) -> {
            TaxCalculation reduced = entry1.getValue().add( entry2.getValue() );
            return new AbstractMap.SimpleEntry<>( entry1.getKey(), reduced );
        };
    }

    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    @JsonIgnore
    public Optional<TaxDecisionResult> getTaxDecisionResult( LocationLevel level ) {
        return Optional.ofNullable( taxDecisionResults.get( level ) );
    }

    public EnumMap<LocationLevel, TaxDecisionResult> getTaxDecisionResults() {
        return taxDecisionResults;
    }

    public Optional<TaxTotalInLocalCurrency> getTaxTotalInLocalCurrency() {
        return Optional.ofNullable( taxTotalInLocalCurrency );
    }

    public Map<LocationLevel, TaxRegistrationResult> getTaxRegistrations() {
        return taxRegistrations;
    }

    public Map<LocationLevel, List<TaxIndicatorComment>> getTaxIndicatorComments() {
        return taxIndicatorComments;
    }

    @JsonIgnore
    public PostTaxInvoice addExchangeInfo( String currencyCode, Amount exchangeRate, Amount taxAmount ) {
        TaxTotalInLocalCurrency inLocalCurrency = new TaxTotalInLocalCurrency( currencyCode, exchangeRate, taxAmount );
        return new PostTaxInvoice( invoiceLines, taxDecisionResults, taxRegistrations, inLocalCurrency, taxIndicatorComments, priceType );
    }

    @JsonIgnore
    public PostTaxInvoice addTaxRegistrations( Map<LocationLevel, TaxRegistrationResult> taxRegistrations ) {
        return new PostTaxInvoice( invoiceLines, taxDecisionResults, taxRegistrations, taxTotalInLocalCurrency, taxIndicatorComments, priceType );
    }

    @JsonIgnore
    public PostTaxInvoice addTaxIndicatorComments( Map<LocationLevel, List<TaxIndicatorComment>> taxIndicatorComments ) {
        return new PostTaxInvoice( invoiceLines, taxDecisionResults, taxRegistrations, taxTotalInLocalCurrency, taxIndicatorComments, priceType );
    }

    @JsonIgnore
    public Map<TaxRate, TotalCalculation> getTaxRateTotal( TaxDecisionResult taxDecisionResult ) {
        Map<TaxRate, TaxCalculation> indicatorTaxCalculationMap = taxTotals.get( taxDecisionResult );
        Map<TaxRate, TotalCalculation> totalCalculationMap = new HashMap<>();
        if ( indicatorTaxCalculationMap != null ) {
            totalCalculationMap = indicatorTaxCalculationMap.entrySet().stream()
                            .collect( toMap( e -> e.getKey(),
                                            entry -> {
                                                TaxCalculation taxCalculation = entry.getValue();
                                                TotalCalculation totalCalculation =
                                                                new TotalCalculation( taxCalculation.getBaseAmount(),
                                                                                taxCalculation.getTaxAmount(),
                                                                                taxCalculation.getTotalAmount() );
                                                return totalCalculation;
                                            } ) );
        }
        return totalCalculationMap;
    }

    @JsonIgnore
    public Optional<TotalCalculation> getTaxTypeTotal( TaxDecisionResult taxDecisionResult ) {
        Map<TaxRate, TotalCalculation> taxRateTotals = getTaxRateTotal( taxDecisionResult );
        Optional<TotalCalculation> taxTypeTotal = taxRateTotals.entrySet().stream()
                        .map( e -> e.getValue() )
                        .reduce( TotalCalculation::add );
        return taxTypeTotal;
    }

    @JsonIgnore
    public TotalCalculation getInvoiceTotal() {
        TotalCalculation totalCalculation = getTaxTypeTotal(taxDecisionResults.get(LocationLevel.COUNTRY)).get();
        Amount baseTotal = totalCalculation.getBaseTotal();
        Amount taxTotal = taxDecisionResults.values().stream()
                .map(tdr -> getTaxTypeTotal(tdr))
                .filter(Optional::isPresent)
                .map(t -> t.get().getTaxTotal())
                .reduce(Amount::add)
                .get();

        Amount total;
        if(priceType == PriceType.NET) {
            total = baseTotal.add(taxTotal);
        } else {
            // There can be only one result in gross calculation, more are not supported yet
            total = totalCalculation.getTotal();
        }
        TotalCalculation invoiceTotal = new TotalCalculation(baseTotal, taxTotal, total);
        return invoiceTotal;
    }

    @JsonIgnore
    public Optional<Jurisdiction> getSellerCountryJurisdiction() {
        for( TaxDecisionResult key : taxTotals.keySet() ) {
            Jurisdiction sellerJurisdiction = key.getSellerJurisdiction();
            if( sellerJurisdiction.getLocationLevel() == LocationLevel.COUNTRY ) {
                return Optional.of( sellerJurisdiction );
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        PostTaxInvoice that = (PostTaxInvoice) o;
        return Objects.equals( taxDecisionResults, that.taxDecisionResults ) &&
                        Objects.equals( invoiceLines, that.invoiceLines ) &&
                        Objects.equals( taxTotalInLocalCurrency, that.taxTotalInLocalCurrency ) &&
                        Objects.equals( taxRegistrations, that.taxRegistrations ) &&
                        Objects.equals( taxIndicatorComments, that.taxIndicatorComments );
    }

    @Override
    public int hashCode() {
        return Objects.hash( taxDecisionResults, invoiceLines, taxTotalInLocalCurrency, taxRegistrations, taxIndicatorComments );
    }
}
