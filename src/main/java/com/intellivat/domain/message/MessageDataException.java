package com.intellivat.domain.message;

public class MessageDataException
                extends RuntimeException {

    private static final long serialVersionUID = -2389416334854671178L;

    private final MessageData messageData;

    public MessageDataException( String message, MessageData messageData ) {
        super( message );
        this.messageData = messageData;
    }

    public MessageData getMessageData() {
        return messageData;
    }
}
