package com.luoxiaobatman.assignment.interview.coding.citibank;


import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 */
@AllArgsConstructor
public class Print20NumsOP
        extends AbstractSolution<int[]> implements GenericSolution<int[]> {
    private final int l;

    @Override
    public int[] doSolve() {
        List<Integer> result = new ArrayList<>();
        Future<?>[] futures = new Future<?>[l];
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < l; i++) {
            final int j = i;
            Future<?> future = executorService.submit(() -> {
                if (j > 0) {
                    try {
                        futures[j - 1].get();
                    } catch (InterruptedException | ExecutionException ignored) { }
                }
                result.add(j);
                System.out.println("" + j + " " + Thread.currentThread().getId());
            });
            futures[i] = future;
        }
        try {
            futures[futures.length - 1].get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        int[] resultArray = new int[l];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
