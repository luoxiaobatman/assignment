package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 *
 */
@AllArgsConstructor
public class P277
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int n;

    @Override
    public Integer doSolve() {
        return findCelebrity(n);
    }

    public int findCelebrity(int n) {
        boolean goRight = true;  // 初始往右
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (i == j) {
                if (goRight) {
                    j++;
                } else {
                    i++;
                }
                continue;
            }
            if (knows(i, j)) {
                goRight = false;
                i++;
            } else {
                goRight = true;
                j++;
            }
        }
        int s = 0;
        if (i == n) {
            s = j;
        }
        if (j == n) {
            s = i;
        }
        for (int k = 0; k < n; k++) {
            if (k == s) continue;
            if (!knows(k, s)) return -1;
            if (knows(s, k)) return 1;
        }
        return s;
    }



    private boolean knows(int a, int b) {
        return a - b > 0;
    }
}
