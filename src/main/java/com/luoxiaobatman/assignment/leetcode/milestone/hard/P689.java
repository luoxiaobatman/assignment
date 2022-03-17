package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;

@AllArgsConstructor
public class P689
        extends AbstractSolution<int[]> implements GenericSolution<int[]> {
    private final int[] nums;
    private final int k;

    @Override
    public int[] doSolve() {
        return maxSumOfThreeSubarrays(nums, k);
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int l = nums.length + 1;
        int[] sumK = new int[l];
        int s = 0;
        for (int i = 0; i < k; i++) {
            s += nums[i];
        }
        sumK[k] = s;
        for (int i = k + 1; i < l; i++) {
            sumK[i] = sumK[i - 1] - nums[i - k - 1] + nums[i - 1];
        }

        int[][] dp1 = new int[l][];
        dp1[k] = new int[] {sumK[k], 0};
        for (int i = k + 1; i < l; i++) {
            dp1[i] = dp1[i - 1];
            if (sumK[i] > dp1[i][0]) {
                dp1[i] = new int[] {sumK[i], i - k};
            }
        }

        int[][] dp2 = new int[l][];
        dp2[2 * k] = new int[] {sumK[k] + sumK[2 * k], 0, k};
        for (int i = 2 * k + 1; i < l; i++) {
            dp2[i] = dp2[i - 1];
            int[] dp1i = dp1[i - k];
            if (sumK[i] + dp1i[0] > dp2[i][0]) {
                dp2[i] = new int[] {sumK[i] + dp1i[0], dp1i[1], i - k};
            }
        }

        int[][] dp3 = new int[l][];
        dp3[3 * k] = new int[] {sumK[k] + sumK[2 * k] + sumK[3 * k], 0, k, 2 * k};
        for (int i = 3 * k + 1; i < l; i++) {
            dp3[i] = dp3[i - 1];
            int[] dp2i = dp2[i - k];
            int sum = sumK[i] + dp2i[0];
            if (sum > dp3[i][0]) {
                dp3[i] = new int[] {sum, dp2i[1], dp2i[2], i - k};
            }
        }
        return Arrays.copyOfRange(dp3[nums.length], 1, 4);
    }
}
