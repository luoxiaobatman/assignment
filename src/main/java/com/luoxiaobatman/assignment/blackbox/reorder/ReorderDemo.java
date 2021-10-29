package com.luoxiaobatman.assignment.blackbox.reorder;

import sun.misc.Unsafe;

import java.lang.ref.Cleaner;
import java.util.Base64;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReorderDemo {
    public static final Object monitor1 = new Object();
    public static final Object monitor2 = new Object();
    public static volatile int a = 0;
    public static int b = 0;
    public static int x = 0;
    public static int y = 0;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10000000; i++) {
            a = 0;
            b = 0;
            x = 0;
            y = 0;
            Future<?> submit1 = executorService.submit(() -> {
                a = 1;
                y = b;
            });
            Future<?> submit2 = executorService.submit(() -> {
                b = 1;
                x = a;
            });
            submit1.get();
            submit2.get();
            if (y == 0 && x == 0) {
                System.out.println(x + "," + y);
            }
        }
    }
}
