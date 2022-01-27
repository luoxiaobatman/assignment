package com.luoxiaobatman.assignment.datastructure.stack;


import java.util.ArrayList;

public class ArrayStack<E> extends ArrayList<E> implements Stack<E> {
    @Override
    public E peek() {
        return get(size() - 1);
    }

    @Override
    public E pop() {
        return remove(size() - 1);
    }

    @Override
    public void push(E e) {
        add(e);
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }
}
