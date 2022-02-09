package com.luoxiaobatman.assignment.datastructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * 单调栈
 * <p>
 * 面试写不出来 就别搞开发了好不好
 */
public class MonoStack<E extends Comparable<E>> implements Stack<E> {
    private final Deque<E> deque = new ArrayDeque<>();
    /**
     * 单调增 1
     * 单调减 -1
     */
    private final int arrowOfOrder;

    public MonoStack(boolean inc) {
        if (inc) {
            this.arrowOfOrder = 1;
        } else {
            this.arrowOfOrder = -1;
        }
    }

    @Override
    public E peek() {
        return deque.peek();
    }

    @Override
    public E pop() {
        return deque.pop();
    }

    @Override
    public void push(E e) {
        assert e != null;
        mono(e, null, null);
    }

    private void mono(E e, Consumer<E> preOrderConsumer, Consumer<E> postOrderConsumer) {
        Deque<E> postOrderStack = null;
        if (postOrderConsumer != null) {
            postOrderStack = new ArrayDeque<>();
        }
        for (; ; ) {
            try {
                E popped = pop();
                if (e.compareTo(popped) * arrowOfOrder >= 0) {
                    deque.push(popped);
                    break;
                } else if (preOrderConsumer != null) {
                    preOrderConsumer.accept(popped);
                }
                if (postOrderStack != null) {
                    postOrderStack.push(popped);
                }
            } catch (NoSuchElementException ignored) {
                // 到达栈底
                break;
            }
        }
        if (postOrderStack != null) {
            try {
                postOrderConsumer.accept(postOrderStack.pop());
            } catch (NoSuchElementException ignored) {}
        }
        deque.push(e);
    }


    /**
     * @param e                 压栈元素
     * @param preOrderConsumer  前序遍历算法
     * @param postOrderConsumer 后序遍历算法
     */
    public void push(E e, Consumer<E> preOrderConsumer, Consumer<E> postOrderConsumer) {
        assert e != null;
        mono(e, preOrderConsumer, postOrderConsumer);
    }


    @Override
    public boolean empty() {
        return deque.isEmpty();
    }

    @Override
    public int size() {
        return deque.size();
    }
}
