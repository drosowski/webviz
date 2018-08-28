package com.intellivat.domain.message;

public enum KnownMessages {

    GENERIC_ERROR( MessageType.ERROR, "100" ),
    EXCPETION_NODE_ERROR( MessageType.ERROR, "106" ),
    PRETAX_INVOICE_NOT_VALID_AGAINST_XSD( MessageType.ERROR, "108" ),
    TAXRATE_FOR_UNSPSC_NOT_FOUND( MessageType.ERROR, "109" ),
    PRETAX_VALIDATION_ERROR( MessageType.ERROR, "110" ),
    PRETAX_VALIDATION_VALUE_ERROR( MessageType.ERROR, "111" ),
    UNSPSC_LOOKUP_ROOT( MessageType.WARNING, "112" ),
    UNSPSC_RATE_ROOT( MessageType.INFORMATION, "113" ),
    TAXRATE_FOR_TAX_RATE_INDICATOR_NOT_FOUND( MessageType.ERROR, "114" ),
    MISSING_TAX_REGISTRATION_WARNING( MessageType.WARNING, "115" ),
    NOT_SUPPORTED( MessageType.ERROR, "117" ),
    EXCHANGE_TABLE_INCOMPLETE( MessageType.ERROR, "118"),
    EXCHANGE_TABLE_MISSING( MessageType.ERROR, "119" );

    private final String code;

    private final MessageType type;

    KnownMessages( MessageType type, String code ) {
        this.type = type;
        this.code = code;
    }

    public MessageData messageData( Object... arguments ) {
        return new MessageData( type, code, arguments );
    }
}
