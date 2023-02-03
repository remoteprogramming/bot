package com.mob.chatops.runner;

public interface CommandRunner {
     boolean match(String messageContent);

     void run(MessageEventHandler messageEventHandler);

}
