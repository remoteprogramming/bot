package com.mob.chatops.runner.impl;

import com.mob.chatops.processor.impl.EventType;
import com.mob.chatops.runner.MessageEventHandler;
import lombok.Builder;
import org.javacord.api.event.message.CertainMessageEvent;

@Builder
public class MessageEventHandlerJavacord implements MessageEventHandler {

    private CertainMessageEvent messageEvent;
    private EventType type;

    @Override
    public EventType getType() {
        return this.type;
    }

    @Override
    public String getContent() {
        return messageEvent.getMessageContent();
    }

    @Override
    public void sendMessage(String message) {
        this.messageEvent.getChannel().sendMessage(message);
    }
}
