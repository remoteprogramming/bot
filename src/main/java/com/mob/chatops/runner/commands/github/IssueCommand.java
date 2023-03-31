package com.mob.chatops.runner.commands.github;

import com.mob.chatops.runner.CommandRunner;
import com.mob.chatops.runner.MessageEventHandler;
import org.springframework.stereotype.Component;

@Component
public class IssueCommand implements CommandRunner {

  private String name = "!issue-list";

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getDescription() {
    return null;
  }

  @Override
  public boolean match(String messageContent){
    return messageContent.startsWith(this.name);
  }

  public void run(MessageEventHandler messageEventHandler){
    System.out.println("Running Issue Command");
    messageEventHandler.sendMessage("There's no issue yet");
  }
}