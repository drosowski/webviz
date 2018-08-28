package com.intellivat.domain.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

/**
 * This class transports all information necessary to lookup a concrete error message
 */
public class MessageData {

    private static final String PREFIX = "code";

    private final MessageType type;

    private final String code;

    private final Object[] arguments;

    public MessageData( MessageType type, String code ) {
        this( type, code, null );
    }

    @JsonCreator
    public MessageData( @JsonProperty( "type" ) MessageType type,
                        @JsonProperty( "code" ) String code,
                        @JsonProperty( "arguments" ) Object[] arguments ) {
        this.type = type;
        this.code = code;
        this.arguments = arguments == null ? new Object[0] : arguments;
    }

    public MessageType getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public String key() {
        return PREFIX + "." + code + "." + type.toString().toLowerCase( Locale.UK );

    }

    @Override
    public String toString() {
        return "MessageData{" +
                        "type=" + type +
                        ", code='" + code + '\'' +
                        ", arguments=" + Arrays.toString( arguments ) +
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
        MessageData that = (MessageData) o;
        return Objects.equals( type, that.type ) &&
                        Objects.equals( code, that.code ) &&
                        Arrays.deepEquals( arguments, that.arguments );
    }

    @Override
    public int hashCode() {
        return Objects.hash( type, code, arguments );
    }
}
