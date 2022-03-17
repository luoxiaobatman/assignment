package com.luoxiaobatman.assignment.jdk.juc;

import java.util.concurrent.*;

public class ThreadExp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Object> cf = CompletableFuture.completedFuture(1);
        System.out.println(cf.get());
    }
}
