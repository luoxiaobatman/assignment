package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class P689Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "1,2,1,2,6,7,5,1", "2", "0,3,5"
    })
    void doSolve(int[] nums, Integer k, int[] expected) {
        int[] actual = Solver.solve(P689.class, nums, k);
        assertArrayEquals(expected, actual);
    }
}
