package com.mob.chatops.processor;

import com.mob.chatops.runner.MessageEventHandler;

public interface CommandProcessor {

    void process(MessageEventHandler messageEvent);
}
