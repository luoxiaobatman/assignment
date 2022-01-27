package com.luoxiaobatman.assignment.datastructure.stack;

/**
 * TODO queues, binary trees, graphs, hash tables
 * @param <E> 栈元素类型
 */
public interface Stack<E> {
    E peek();
    E pop();
    void push(E e);
    boolean empty();
    int size();
}
