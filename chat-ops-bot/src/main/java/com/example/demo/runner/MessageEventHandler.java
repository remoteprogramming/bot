package com.example.demo.runner;

import com.example.demo.processor.impl.EventType;

public interface MessageEventHandler {
    EventType getType();

    String getContent();

    void sendMessage(String message);
}
