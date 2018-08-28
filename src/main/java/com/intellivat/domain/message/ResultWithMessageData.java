package com.intellivat.domain.message;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class ResultWithMessageData<T> {

    private final ImmutableList<MessageData> messageDataList;

    private final T result;

    public ResultWithMessageData( T result, List<MessageData> messageDataList ) {
        this.result = result;
        if ( messageDataList == null ) {
            this.messageDataList = ImmutableList.of();
        } else {
            this.messageDataList = ImmutableList.copyOf( messageDataList );
        }
    }

    public ResultWithMessageData( T result ) {
        this( result, ImmutableList.of() );
    }

    public ImmutableList<MessageData> getMessageDataList() {
        return messageDataList;
    }

    public T getResult() {
        return result;
    }
}
