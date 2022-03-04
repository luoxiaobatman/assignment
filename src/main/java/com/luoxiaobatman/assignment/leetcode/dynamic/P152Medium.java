package com.luoxiaobatman.assignment.leetcode.dynamic;


import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import com.luoxiaobatman.assignment.util.Bits;
import lombok.AllArgsConstructor;

/**
 * 乘积最大数组
 */
@AllArgsConstructor
public class P152Medium
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[] sources;

    @Override
    public Integer doSolve() {
        return maxProduct(sources);
    }

    public int maxProduct(int[] nums) {
        int globalMax = nums[0];
        int prevLocalMax = globalMax;
        int prevLocalMin = globalMax;
        int localMax;
        int localMin;
        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(prevLocalMax * nums[i], nums[i]);
            localMax = Math.max(localMax, prevLocalMin * nums[i]);
            localMin = Math.min(prevLocalMin * nums[i], nums[i]);
            localMin = Math.min(localMin, prevLocalMax * nums[i]);
            prevLocalMax = localMax;
            prevLocalMin = localMin;
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}
