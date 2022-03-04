package com.luoxiaobatman.assignment.leetcode.milestone.spring2022;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import com.luoxiaobatman.assignment.util.Bits;
import lombok.AllArgsConstructor;

/**
 * top bottom left right
 *
 * top = bottom or left = right 退化为普通的二分
 * 否则, 矩阵4分法
 */
@AllArgsConstructor
public class P002
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[][] matrix;

    @Override
    public Integer doSolve() {
        return 1;
    }
}
