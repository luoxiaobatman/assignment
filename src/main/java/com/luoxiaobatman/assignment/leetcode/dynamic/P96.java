package com.luoxiaobatman.assignment.leetcode.dynamic;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class P96
extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int n;
    @Override
    public Integer doSolve() {
        return numTrees(n);
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
