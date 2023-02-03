package com.example.demo.runner.commands.github;

import com.example.demo.runner.CommandRunner;
import com.example.demo.runner.MessageEventHandler;
import org.springframework.stereotype.Component;

@Component
public class TaskCommand implements CommandRunner {
  @Override
  public boolean match(String messageContent){
    return messageContent.startsWith("!issues");
  }

  public void run(MessageEventHandler messageEventHandler){
    messageEventHandler.sendMessage("There's no issue yet");
  }
}