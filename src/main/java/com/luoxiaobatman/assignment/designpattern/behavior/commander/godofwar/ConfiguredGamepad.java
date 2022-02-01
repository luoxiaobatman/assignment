package com.luoxiaobatman.assignment.designpattern.behavior.commander.godofwar;


public class ConfiguredGamepad implements Gamepad {
    private final Action actionMove = new Move();
    private final Action actionSwingAxe = new SwingAxe();
    private final Avatar kratos = new Kratos();

    @Override
    public void move() {
        actionMove.execute(kratos);
    }

    @Override
    public void cross() {
        actionSwingAxe.execute(kratos);
    }

    @Override
    public void square() {

    }

    @Override
    public void triangle() {

    }

    @Override
    public void circle() {

    }
}
