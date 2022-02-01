package com.luoxiaobatman.assignment.designpattern.behavior.commander.godofwar;

public class Move implements Action {
    @Override
    public void execute(Avatar avatar) {
        avatar.move();
    }
}
