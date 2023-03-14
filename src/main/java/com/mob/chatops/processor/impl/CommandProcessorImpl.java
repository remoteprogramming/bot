package com.mob.chatops.processor.impl;

import com.mob.chatops.processor.CommandProcessor;
import com.mob.chatops.runner.CommandRunner;
import com.mob.chatops.runner.MessageEventHandler;
import com.mob.chatops.runner.commands.ListCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CommandProcessorImpl implements CommandProcessor {

    @Autowired
    private Set<CommandRunner> commands;

    @Override
    public void process(MessageEventHandler messageEvent) {
        CommandRunner selectedCommand = null;
        System.out.println("Trying to match command");

        for(CommandRunner c : commands){
            if(c.match(messageEvent.getContent())){
                System.out.println("Matched command "+c.getName());
                if(c instanceof ListCommand){
                    messageEvent.setExtra(commands);
                }
                selectedCommand = c;
                break;
            }
        }

        if(selectedCommand != null){
            System.out.println("Command selected");
            selectedCommand.run(messageEvent);
        }
    }
}
