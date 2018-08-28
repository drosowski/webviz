package com.intellivat.domain.invoice.enriched;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intellivat.domain.invoice.schema.PreTaxInvoice;
import com.intellivat.domain.message.MessageData;

import java.util.List;
import java.util.Optional;

/**
 * The result of {@link InvoicePreprocessor#preprocessPreTaxInvoice(byte[])} that contains
 * <ul>
 * <li>the PreTaxInvoice if the given bytes could be successfully unmarshalled</li>
 * <li>the EnrichedInvoice, in case of success</li>
 * <li>a list of {@link MessageData} from the validation.</li>
 * </ul>
 * 
 * @author Daniel Rosowski
 */
public class InvoicePreprocessingResult {

    private final Optional<EnrichedInvoice> enrichedInvoice;

    private final Optional<PreTaxInvoice> preTaxInvoice;

    private final List<MessageData> validationMessageDataList;

    @JsonCreator
    public InvoicePreprocessingResult( @JsonProperty( "validationMessageDataList" ) List<MessageData> validationMessageDataList,
                                       @JsonProperty( "preTaxInvoice" ) PreTaxInvoice preTaxInvoice,
                                       @JsonProperty( "enrichedInvoice" ) EnrichedInvoice enrichedInvoice ) {
        this.validationMessageDataList = validationMessageDataList;
        this.preTaxInvoice = Optional.ofNullable( preTaxInvoice );
        this.enrichedInvoice = Optional.ofNullable( enrichedInvoice );
    }

    public InvoicePreprocessingResult( List<MessageData> validationMessageDataList ) {
        this( validationMessageDataList, null, null );
    }

    public Optional<EnrichedInvoice> getEnrichedInvoice() {
        return enrichedInvoice;
    }

    public Optional<PreTaxInvoice> getPreTaxInvoice() {
        return preTaxInvoice;
    }

    public List<MessageData> getValidationMessageDataList() {
        return validationMessageDataList;
    }

    @JsonIgnore
    public boolean isFailure() {
        return !enrichedInvoice.isPresent();
    }
}
