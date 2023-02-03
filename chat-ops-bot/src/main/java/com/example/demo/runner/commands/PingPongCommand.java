package com.example.demo.runner.commands;

import com.example.demo.runner.CommandRunner;
import com.example.demo.runner.MessageEventHandler;
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
