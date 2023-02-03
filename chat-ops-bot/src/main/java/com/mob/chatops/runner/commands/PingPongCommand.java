package com.mob.chatops.runner.commands;

import com.mob.chatops.runner.CommandRunner;
import com.mob.chatops.runner.MessageEventHandler;
import org.springframework.stereotype.Component;

@Component
public class PingPongCommand implements CommandRunner {
    @Override
    public boolean match(String messageContent) {
        return messageContent.startsWith("!ping");
    }

    @Override
    public void run(MessageEventHandler messageEventHandler) {
        messageEventHandler.sendMessage("Pong");
    }
}
