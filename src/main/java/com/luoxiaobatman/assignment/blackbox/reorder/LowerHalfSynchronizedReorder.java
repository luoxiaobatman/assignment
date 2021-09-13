package com.luoxiaobatman.assignment.blackbox.reorder;

public class LowerHalfSynchronizedReorder extends Reorder implements IReorder {
    @Override
    public void set() {
        synchronized (this) {
            a = 1;
            c = 1;
        }
        b = 1;
    }
}
