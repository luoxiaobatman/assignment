package com.luoxiaobatman.assignment.blackbox.reorder;

public class SynchronizedReorder extends Reorder implements IReorder {
    @Override
    public void set() {
        synchronized (this) {
            a = 1;
            b = 1;
        }
    }
}
