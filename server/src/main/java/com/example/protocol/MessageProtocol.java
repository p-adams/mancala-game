package com.example.protocol;

import com.example.GameData;

public class MessageProtocol {
    private String messageType;
    private GameData data;

    public MessageProtocol() {
    }

    public GameData getData() {
        return data;
    }

    public String getMessageType() {
        return messageType;
    }
}
