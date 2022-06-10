package com.example.protocol;

import com.example.GameConfig;

public class MessageProtocol {
    private String messageType;
    private GameConfig data;

    public MessageProtocol() {
    }

    public GameConfig getData() {
        return data;
    }

    public String getMessageType() {
        return messageType;
    }
}
