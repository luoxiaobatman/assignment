package com.luoxiaobatman.assignment.unclassified;

import com.luoxiaobatman.assignment.blackbox.aqs.Mutex;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AQSTest {
    @Test
    public void testAQS() throws InterruptedException {
        Mutex mutex = new Mutex();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("process-1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            System.out.println("process-2");
        });
        executorService.shutdown();
        executorService.awaitTermination(1000, TimeUnit.HOURS);
    }
}
