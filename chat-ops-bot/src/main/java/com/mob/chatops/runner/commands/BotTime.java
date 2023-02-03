package com.mob.chatops.runner.commands;

import com.mob.chatops.runner.CommandRunner;
import com.mob.chatops.runner.MessageEventHandler;
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
