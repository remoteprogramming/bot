package com.example.demo.listener.impl;

import com.example.demo.listener.MessageListener;
import com.example.demo.processor.CommandProcessor;
import com.example.demo.processor.impl.EventType;
import com.example.demo.runner.MessageEventHandler;
import com.example.demo.runner.impl.MessageEventHandlerJavacord;
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
       //bring to domain and call processor
        MessageEventHandler messageEventHandler = MessageEventHandlerJavacord.builder()
                .messageEvent(messageCreateEvent)
                .type(EventType.CREATE)
                .build();

        commandProcessor.process(messageEventHandler);
    }
}
