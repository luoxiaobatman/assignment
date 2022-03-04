package com.luoxiaobatman.assignment.interview.coding.bigai;


import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@AllArgsConstructor
public class SameIntsInArray
        extends AbstractSolution<int[]> implements GenericSolution<int[]> {
    private final int[] a;
    private final int[] b;
    @Override
    public int[] doSolve() {
        int i = 0;
        int j = 0;
        List<Integer> resultList = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                resultList.add(a[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[resultList.size()];
        for (int k = 0; k < resultList.size(); k++) {
            result[k] = resultList.get(k);
        }
        return result;
    }
}
