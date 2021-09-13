package com.luoxiaobatman.assignment.blackbox.reorder;

/**
 * 验证CPU指令重排
 */
public abstract class Reorder implements IReorder {
    public static final int REORDERING_HIT = -1;

    volatile int b = 0;
    volatile int a = 0;
    volatile int c = 0;

    public abstract void set();

    public int reordering() {
        return a - b;
    }
}
