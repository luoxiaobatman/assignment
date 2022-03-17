package com.luoxiaobatman.assignment.datastructure.stack;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 线程安全栈
 */
public class TreiberStack<E> {
    private final AtomicReference<Node> topRef = new AtomicReference<>();

    public boolean offer(E e) {
        Node node = new Node(e);
        Node top;
        do {
            top = topRef.get();
            node.next = top;
        } while (!topRef.compareAndSet(top, node));
        return true;
    }

    public E pop() {
        Node top;
        Node next;
        do {
            top = topRef.get();
            if (top != null) {
                next = top.next;
            } else {
                next = null;
            }
        } while (!topRef.compareAndSet(top, next));
        return (E) top.o;
    }

    private static class Node {
        private Object o;
        private Node next;

        public Node(Object o) {
            this.o = o;
        }
    }
}
