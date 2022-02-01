package com.luoxiaobatman.assignment.designpattern.behavior.commander.godofwar;

public class SwingAxe implements Action{
    @Override
    public void execute(Avatar avatar) {
        avatar.swingAxe();
    }
}
