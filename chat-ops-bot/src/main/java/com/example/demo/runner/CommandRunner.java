package com.example.demo.runner;

public interface CommandRunner {
     boolean match(String messageContent);

     void run(MessageEventHandler messageEventHandler);

}
