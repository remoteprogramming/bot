package com.example.demo.runner.commands;

import com.example.demo.runner.CommandRunner;
import com.example.demo.runner.MessageEventHandler;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class BotTime implements CommandRunner {
    @Override
    public boolean match(String messageContent) {
        return messageContent.startsWith("!bottime");
    }

    @Override
    public void run(MessageEventHandler messageEventHandler) {
        messageEventHandler.sendMessage("Bot time is: "+ Instant.now().toString());
    }
}
