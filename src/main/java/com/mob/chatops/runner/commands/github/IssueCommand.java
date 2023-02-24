package com.mob.chatops.runner.commands.github;

import com.mob.chatops.runner.CommandRunner;
import com.mob.chatops.runner.MessageEventHandler;
import org.springframework.stereotype.Component;

@Component
public class IssueCommand implements CommandRunner {
  
  @Override
  public boolean match(String messageContent){
    return messageContent.startsWith("!issue-list");
  }

  public void run(MessageEventHandler messageEventHandler){
    System.out.println("Running Issue Command");
    messageEventHandler.sendMessage("There's no issue yet");
  }
}