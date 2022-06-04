package com.example.protocol;

public class Message {
    private String messageType;
    private int data;

    public Message(String messageType, int data) {
        this.messageType = messageType;
        this.data = data;
    }

    public String getMessageType() {
        return messageType;
    }

    public int getData() {
        return data;
    }
}
