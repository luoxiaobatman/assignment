package com.luoxiaobatman.assignment.datastructure.tree.binarytree;

import com.luoxiaobatman.assignment.designpattern.behavior.vistor.Visitor;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;

import java.util.function.Consumer;

public abstract class BinaryTreeVisitor<R> extends AbstractSolution<R> implements Visitor, GenericSolution<R> {
    final protected BinaryTree binaryTree;
    public BinaryTreeVisitor(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public void visit(Consumer<Visitor> consumer) {
        BinaryTree binaryTree = (BinaryTree) consumer;
        visit(binaryTree);
    };

    abstract protected void visit(BinaryTree binaryTree);
}
