package com.luoxiaobatman.assignment.designpattern.behavior.commander.godofwar;

import com.luoxiaobatman.assignment.designpattern.behavior.commander.Receiver;

public interface Avatar extends Receiver {
    @Override
    default void act() {

    };

    void move();
    void swingAxe();
}
