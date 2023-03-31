package com.mob.chatops.runner.commands;

import com.mob.chatops.runner.CommandRunner;
import com.mob.chatops.runner.MessageEventHandler;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ListCommand implements CommandRunner {
    private String name = "!list";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public boolean match(String messageContent) {
        return messageContent.startsWith(this.name);
    }

    @Override
    public void run(MessageEventHandler messageEventHandler) {
        Set<CommandRunner> commands = (Set<CommandRunner>) messageEventHandler.getExtra();
        String commandsList = commands.stream().map(x -> x.getName() + " - " + x.getDescription()).collect(Collectors.joining("\n"));
        messageEventHandler.sendMessage("Available commands: \n" + commandsList);
    }
}
