package com.luoxiaobatman.assignment.designpattern.behavior.commander.godofwar;

import com.luoxiaobatman.assignment.designpattern.behavior.commander.Command;
import com.luoxiaobatman.assignment.designpattern.behavior.commander.Receiver;

public interface Action extends Command {
    @Override
    default void execute(Receiver receiver) {
        if (receiver instanceof Avatar) {
            execute((Avatar) receiver);
        }
    }

    void execute(Avatar avatar);
}
