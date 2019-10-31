package com.codegym.task.task30.task3008;

import java.io.Serializable;

public class Message implements Serializable {
    private final MessageType type;
    private final String data;

    public Message(MessageType type) {
        this.type = type;
        this.data=null;
    }
    public Message(MessageType type, String message) {
        this.type = type;
        this.data=message;
    }

    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }

}
