package com.example.demo.processor;

import com.example.demo.runner.MessageEventHandler;

public interface CommandProcessor {

    void process(MessageEventHandler messageEvent);
}
