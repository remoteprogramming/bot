package com.example.demo.processor.impl;

import com.example.demo.processor.CommandProcessor;
import com.example.demo.runner.CommandRunner;
import com.example.demo.runner.MessageEventHandler;
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

        for(CommandRunner c : commands){
            if(c.match(messageEvent.getContent())){
                selectedCommand = c;
                break;
            }
        }

        if(selectedCommand != null){
            selectedCommand.run(messageEvent);
        }
    }
}
