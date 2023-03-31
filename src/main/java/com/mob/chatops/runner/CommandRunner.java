package com.mob.chatops.runner;

public interface CommandRunner {
     String getName();

     String getDescription();

     boolean match(String messageContent);

     void run(MessageEventHandler messageEventHandler);

}
