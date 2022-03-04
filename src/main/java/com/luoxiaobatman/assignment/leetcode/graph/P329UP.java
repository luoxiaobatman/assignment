package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 广度优先, 出度(拓扑排序)
 */
@AllArgsConstructor
public class P329UP
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[][] matrix;

    @Override
    public Integer doSolve() {
        return longestIncreasingPath(matrix);
    }

    /**
     * 做不出来, 就不要再写代码了
     */
    public int longestIncreasingPath(int[][] matrix) {
        return 0;
    }


}
