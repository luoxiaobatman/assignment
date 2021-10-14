package com.luoxiaobatman.assignment.leetcode.trivial;

public class Util {
    public static void swap(int[] source, int i, int j) {
        if (i == j) return;
        int tmp = source[i];
        source[i] = source[j];
        source[j] = tmp;
    }

    /**
     * 最优计算方法, 动态规划
     * @param source, length=n, n<32
     * @return 所有子集(2^n)的和, 空集dp[0] = 0
     */
    public static int[] subsetSum(int[] source) {
        assert source.length < 32;
        if (source.length == 0) return new int[]{0};
        int n = source.length;
        int[] dp = new int[1 << n];
        int k = -1;
        while ((k = k + 1) < n) {
            int mask = (1 << k) - 1;
            for (int i = 1 << k; i < 1 << (k + 1); i++) {
                dp[i] = source[k] + dp[i & mask];
            }
        }
        return dp;
    }
}
