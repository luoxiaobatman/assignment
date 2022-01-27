package com.luoxiaobatman.assignment.datastructure.stack;

import com.luoxiaobatman.assignment.datastructure.list.LinkedList;

/**
 * LinkedList backed Stack
 *
 * @param <E> 栈元素类型
 */
public class LinkedListStack<E>
        extends LinkedList<E>
        implements Stack<E> {
    /**
     * 入栈
     */
    @Override
    public void push(E e) {
        add(0, e);
    }

    /**
     * 出栈
     *
     * @return 栈顶元素, 空栈返回null
     */
    @Override
    public E pop() {
        return remove(0);
    }

    /**
     * @return 栈顶元素, 空栈返回null
     */
    @Override
    public E peek() {
        return get(0);
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }
}
