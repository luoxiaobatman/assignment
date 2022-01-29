package com.luoxiaobatman.assignment.designpattern.behavior.vistor;
import java.util.function.Consumer;

public class MuseumVisitor implements Visitor {
    @Override
    public void visit(Consumer<Visitor> consumer) {
        if (consumer instanceof Artifact) {
            alg((Artifact) consumer);
        } else {
        }
    }

    private void alg(Artifact artifact) {}
}
