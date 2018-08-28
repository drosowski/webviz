package com.intellivat.domain.taxtree;

public enum ConnectorType {

    YES,
    NO;

    public static ConnectorType valueOf( boolean value ) {
        return value ? YES : NO;
    }
}
