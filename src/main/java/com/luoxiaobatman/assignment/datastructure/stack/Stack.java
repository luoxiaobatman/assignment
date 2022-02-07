package com.luoxiaobatman.assignment.datastructure.stack;

/**
 * 用Deque接口
 *
 * @param <E> 栈元素类型
 * @see java.util.Deque
 */
public interface Stack<E> {
    E peek();
    E pop();
    void push(E e);
    boolean empty();
    int size();
}
