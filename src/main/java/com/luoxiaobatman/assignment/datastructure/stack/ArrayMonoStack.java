package com.luoxiaobatman.assignment.datastructure.stack;

/**
 * 单调栈(并不是), 总数和最大
 * <p>
 * 栈里面的数字的和最大
 *
 * @see com.luoxiaobatman.assignment.leetcode.greedy.P321HardFaster
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
        int order;
        for (int i = 0; i < size - 1; i++) {
            order = get(i).compareTo(get(i + 1));
            if ((inc && order < 0) || (!inc && order > 0)) {
                remove(i);
                add(e);
                return;
            }
        }
        order = get(size - 1).compareTo(e);
        if ((inc && order < 0) || (!inc && order > 0)) {
            remove(size - 1);
            add(e);
        }
    }
}
