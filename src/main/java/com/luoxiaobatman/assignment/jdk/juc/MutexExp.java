package com.luoxiaobatman.assignment.jdk.juc;

import com.luoxiaobatman.assignment.blackbox.aqs.Mutex;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MutexExp {
    public static class Mutex {
        public static class Sync extends AbstractQueuedSynchronizer {
            @Override
            protected boolean tryAcquire(int arg) {
                assert arg == 1;

                return super.tryAcquire(arg);
            }

            @Override
            protected boolean tryRelease(int arg) {
                return super.tryRelease(arg);
            }
        }
    }

    public static void main(String[] args) {

    }
}
