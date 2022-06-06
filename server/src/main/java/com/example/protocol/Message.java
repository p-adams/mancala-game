package com.example.protocol;

public class Message {
    private String messageType;
    private Object data;

    public Message(String messageType, Object data) {
        this.messageType = messageType;
        this.data = data;
    }

    public String getMessageType() {
        return messageType;
    }

    public Object getData() {
        return data;
    }
}
