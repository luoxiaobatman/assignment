package com.luoxiaobatman.assignment.designpattern.behavior.vistor.zooseum;

import com.luoxiaobatman.assignment.designpattern.behavior.vistor.Visitor;

import java.util.function.Consumer;

public class ZooVisitor implements Visitor {
    @Override
    public void visit(Consumer<Visitor> consumer) {
        if (consumer instanceof Animal) {
            alg((Animal) consumer);
        } else {
        }
    }

    private void alg(Animal animal) {}
}
