package com.mob.chatops.runner.commands;

import com.mob.chatops.runner.CommandRunner;
import com.mob.chatops.runner.MessageEventHandler;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class BotTime implements CommandRunner {
    private String name = "!bottime";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return "Returns the current time at bot server.";
    }
    @Override
    public boolean match(String messageContent) {
        return messageContent.startsWith(this.name);
    }

    @Override
    public void run(MessageEventHandler messageEventHandler) {
        messageEventHandler.sendMessage("Bot time is: "+ Instant.now().toString());
    }
}
