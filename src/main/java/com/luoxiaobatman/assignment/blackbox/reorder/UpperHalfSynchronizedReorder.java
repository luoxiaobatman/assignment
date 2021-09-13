package com.luoxiaobatman.assignment.blackbox.reorder;

public class UpperHalfSynchronizedReorder extends Reorder implements IReorder {
    @Override
    public void set() {
        a = 1;
        synchronized (this) {
            b = 1;
        }
    }
}
