package com.luoxiaobatman.assignment.blackbox;

import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.*;

public class Playground {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        TransferQueue<Integer> tq = new LinkedTransferQueue<>();
        executorService.execute(() -> {
            try {
                Integer take = tq.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        Thread.sleep(1000);
        tq.transfer(1);
        tq.offer(1);
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
//        try {
//            tq.transfer(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
