package com.intellivat.domain.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Comparator;
import java.util.Objects;

public class Message {

    public static final Comparator<Message> MESSAGE_COMPARATOR =
            Comparator.comparing( Message::getType ).thenComparing( Message::getMessageText );

    private final MessageType type;

    private final String code;

    private final String messageText;

    @JsonCreator
    public Message( @JsonProperty( "type" ) MessageType type,
                    @JsonProperty( "code" ) String code,
                    @JsonProperty( "messageText" ) String messageText ) {
        this.type = type;
        this.code = code;
        this.messageText = messageText;
    }

    public Message( MessageData messageData, String message ) {
        this( messageData.getType(), messageData.getCode(), message );
    }

    public MessageType getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getMessageText() {
        return messageText;
    }

    @Override
    public String toString() {
        return "Message{" +
                        "type=" + type +
                        ", code='" + code + '\'' +
                        ", messageText='" + messageText + '\'' +
                        '}';
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Message message1 = (Message) o;
        return Objects.equals( type, message1.type ) &&
                        Objects.equals( code, message1.code ) &&
                        Objects.equals( messageText, message1.messageText );
    }

    @Override
    public int hashCode() {
        return Objects.hash( type, code, messageText );
    }
}
