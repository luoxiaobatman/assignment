package com.luoxiaobatman.assignment.datastructure.list;

import java.util.AbstractList;
import java.util.List;

/**
 * 线程安全
 * 性能低
 *
 * @param <T> 元素类型
 */
public class LinkedList<T> extends AbstractList<T> implements List<T> {
    private Node head;
    private int size;

    private void absorb(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T remove(int index) {
        synchronized (this) {
            absorb(index);
            Node pre = null;
            Node removed = head;
            while (index-- > 0) {
                pre = removed;
                removed = removed.next;
            }
            if (pre == null) {
                if (head != null) {
                    head = head.next;
                }
            } else {
                pre.next = removed.next;
            }
            size = Math.max(0, size - 1);
            return (T) removed.value;
        }
    }

    /**
     * @param index   if it is not in range(0, size), truncate
     * @param element ...
     */
    @Override
    public synchronized void add(int index, T element) {
        synchronized (this) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }

            Node pre = null;
            Node shifted = head;
            while (index-- > 0) {
                pre = shifted;
                shifted = shifted.next;
            }
            Node newNode = new Node(element);
            if (pre == null) {
                head = newNode;
            } else {
                pre.next = newNode;
            }
            newNode.next = shifted;
            size++;
        }
    }

    @Override
    public T get(int index) {
        synchronized (this) {
            absorb(index);
            Node target = head;
            while (index-- > 0) {
                target = head.next;
            }
            if (target == null) return null;
            return (T) target.value;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node {
        Object value;
        Node next;

        Node(Object data) {
            this.value = data;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;

            if (!(obj instanceof Node other)) {
                return false;
            }

            if (value == null) {
                return other.value == null;
            }
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            if (value == null) {
                return 0;
            }
            return value.hashCode();
        }
    }
}
