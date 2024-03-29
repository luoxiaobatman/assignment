package com.luoxiaobatman.assignment.designpattern.behavior.vistor.zooseum;


import com.luoxiaobatman.assignment.designpattern.behavior.vistor.Visitor;

import java.util.function.Consumer;

public abstract class Artifact implements Consumer<Visitor> {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
