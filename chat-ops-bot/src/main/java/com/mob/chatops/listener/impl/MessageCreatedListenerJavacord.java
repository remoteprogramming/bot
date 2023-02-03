package com.mob.chatops.listener.impl;

import com.mob.chatops.processor.CommandProcessor;
import com.mob.chatops.processor.impl.EventType;
import com.mob.chatops.runner.MessageEventHandler;
import com.mob.chatops.runner.impl.MessageEventHandlerJavacord;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageCreatedListenerJavacord implements MessageCreateListener {

    @Autowired
    CommandProcessor commandProcessor;

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        System.out.println("Create message event received");
       //bring to domain and call processor
        MessageEventHandler messageEventHandler = MessageEventHandlerJavacord.builder()
                .messageEvent(messageCreateEvent)
                .type(EventType.CREATE)
                .build();

        commandProcessor.process(messageEventHandler);
    }
}
