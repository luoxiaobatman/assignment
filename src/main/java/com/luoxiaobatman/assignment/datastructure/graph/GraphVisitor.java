package com.luoxiaobatman.assignment.datastructure.graph;

import com.luoxiaobatman.assignment.designpattern.behavior.vistor.Visitor;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;

import java.util.function.Consumer;

public abstract class GraphVisitor<R> extends AbstractSolution<R> implements Visitor, GenericSolution<R> {
    final protected Graph graph;
    public GraphVisitor(Graph g) {
        this.graph = g;
    }

    @Override
    public void visit(Consumer<Visitor> consumer) {
        Graph graph = (Graph) consumer;
        visit(graph);
    };

    abstract protected void visit(Graph graph);
}
