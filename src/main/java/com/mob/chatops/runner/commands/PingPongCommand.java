package com.mob.chatops.runner.commands;

import com.mob.chatops.runner.CommandRunner;
import com.mob.chatops.runner.MessageEventHandler;
import org.springframework.stereotype.Component;

@Component
public class PingPongCommand implements CommandRunner {
    private String name =  "!ping";
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return "returns pong";
    }

    @Override
    public boolean match(String messageContent) {
        return messageContent.startsWith(this.name);
    }

    @Override
    public void run(MessageEventHandler messageEventHandler) {
        messageEventHandler.sendMessage("Pong");
    }
}
