package com.luoxiaobatman.assignment.interview.coding.cit;

import java.util.concurrent.*;

public class Print20Nums {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = i;
        }

        var ref = new Object() {
            int next = 0;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 7; i++) {
            var refOfLastOne = new Object() {
                Future<?> lastOne = null;
            };
            for (int j = 0; j < 3; j++) {
                Future<?> future = executorService.submit(() -> {
                    if (refOfLastOne.lastOne != null) {
                        try {
                            refOfLastOne.lastOne.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("" + array[ref.next] + " " + Thread.currentThread().getId());
                    ref.next++;
                });
                future.get();
                refOfLastOne.lastOne = future;
            }
        }
    }
}
