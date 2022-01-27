package com.luoxiaobatman.assignment.datastructure.stack;

/**
 * 单调栈
 * 线程不安全
 * 元素个数大于1
 */
public class ArrayMonoStack<E extends Comparable<E>> extends ArrayStack<E> implements Stack<E> {
    private boolean inc;
    private int size;
    public ArrayMonoStack(boolean inc, int size) {
        super();
        this.inc = inc;
        this.size = size;
    }

    @Override
    public void push(E e) {
        if (this.size() < size) {
            super.push(e);
        } else {
            mono(e);
        }
    }

    private void mono(E e) {
        int compared;
        for (int i = 0; i < size - 1; i++) {
            compared = get(i).compareTo(get(i + 1));
            if ((inc && compared < 0) || (!inc && compared > 0 )) {
                remove(i);
                add(e);
                return;
            }
        }
        compared = get(size -1).compareTo(e);
        if ((inc && compared < 0) || (!inc && compared > 0 )) {
            remove(size - 1);
            add(e);
        }
    }
}
