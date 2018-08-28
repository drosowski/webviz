package com.intellivat.domain.invoice.taxationresult;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.intellivat.domain.invoice.schema.PreTaxInvoice;
import com.intellivat.domain.masterdata.SnapshotToken;
import com.intellivat.domain.message.Message;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
public class TaxationResult {

    private final List<Message> messages;

    private final PreTaxInvoice preTaxInvoice;

    private final List<PostTaxInvoice> postTaxInvoices;

    private final SnapshotToken snapshotToken;

    @JsonCreator
    public TaxationResult( @JsonProperty( "preTaxInvoice" ) PreTaxInvoice preTaxInvoice,
                           @JsonProperty( "postTaxInvoices" ) List<PostTaxInvoice> postTaxInvoices,
                           @JsonProperty( "messages" ) List<Message> messages,
                           @JsonProperty( "snapshotToken" ) SnapshotToken snapshotToken ) {
        this.preTaxInvoice = preTaxInvoice;
        this.postTaxInvoices = postTaxInvoices;
        this.messages = messages.stream().sorted( Message.MESSAGE_COMPARATOR ).collect( Collectors.toList() );
        this.snapshotToken = snapshotToken;
    }

    @JsonTypeInfo( use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class" )
    public Optional<PreTaxInvoice> getPreTaxInvoice() {
        return Optional.ofNullable( preTaxInvoice );
    }


    public List<PostTaxInvoice> getPostTaxInvoices() {
        return postTaxInvoices;
    }

    public SnapshotToken getSnapshotToken() {
        return snapshotToken;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
