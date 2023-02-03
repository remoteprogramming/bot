package com.mob.chatops.runner;

import com.mob.chatops.processor.impl.EventType;

public interface MessageEventHandler {
    EventType getType();

    String getContent();

    void sendMessage(String message);
}
