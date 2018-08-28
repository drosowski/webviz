package com.intellivat.domain.invoice;

import java.util.Locale;
import java.util.Objects;

import javax.xml.bind.annotation.XmlType;

/**
 * Contains additional (meta) data about the incoming request, e.g. communication language, source system, control
 * infos.
 * 
 * @author Alex Rommel
 */
// This needs to be changed as soon as we define the schema for PostTaxInvoice!
@XmlType( namespace = "http://intellivat.com/invoice/pretax" )
public class DocumentInfo {

    private Locale communicationLanguage;

    /**
     * Copy constructor
     */
    public DocumentInfo( DocumentInfo docInfo ) {
        if ( docInfo != null ) {
            this.communicationLanguage = docInfo.communicationLanguage;
        }
    }

    public DocumentInfo( Locale communicationLanguage){
        this.communicationLanguage = communicationLanguage;
    }

    /**
     * Default constructor
     */
    public DocumentInfo() {}

    public Locale getCommunicationLanguage() {
        return communicationLanguage;
    }

    public void setCommunicationLanguage( Locale communicationLanguage ) {
        this.communicationLanguage = communicationLanguage;
    }

    @Override
    public String toString() {
        return "DocumentInfo [communicationLanguage=" + communicationLanguage + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.communicationLanguage );
    }

    @Override
    public boolean equals( Object obj ) {
        if ( !( obj instanceof DocumentInfo ) ) {
            return false;
        }

        final DocumentInfo other = (DocumentInfo) obj;
        return Objects.equals( this.communicationLanguage, other.communicationLanguage );
    }

    public final static class Builder {

        private DocumentInfo instance;

        private Builder() {}

        public static Builder create() {
            Builder builder = new Builder();
            builder.instance = new DocumentInfo();
            return builder;
        }

        public Builder withCommunicationLanguage( Locale communicationLanguage ) {
            this.instance.setCommunicationLanguage( communicationLanguage );
            return this;
        }

        public DocumentInfo build() {
            return instance;
        }
    }

}
