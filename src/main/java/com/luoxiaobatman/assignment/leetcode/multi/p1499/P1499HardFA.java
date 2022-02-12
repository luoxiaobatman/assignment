package com.luoxiaobatman.assignment.leetcode.multi.p1499;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

/**
 * 暴力
 * <p>
 * 超时了
 *
 * <a href="https://leetcode-cn.com/problems/max-value-of-equation/">满足不等式的最大值</a>
 */
@AllArgsConstructor
public class P1499HardFA
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[][] points;
    private final int k;

    @Override
    public Integer doSolve() {
        return findMaxValueOfEquation(points, k);
    }

    // =========== leetcode =============
    public int findMaxValueOfEquation(int[][] points, int k) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            int xi = points[i][0];
            for (int j = i + 1; j < points.length; j++) {
                if (points[j][0] - xi > k) {
                    break;
                } else {
                    result = Math.max(result, equation(points[i], points[j]));
                }
            }
        }
        return result;
    }

    private int equation(int[] pointI, int[] pointJ) {
        return pointJ[0] + pointJ[1] + pointI[1] - pointI[0];
    }
}
