package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P329Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "9|9|4,6|6|8,2|1|1", "4",
            "4|5,2|6", "4",
            "1|2", "2",
    })
    void doSolve(int[][] matrix, Integer expected) {
        Integer actual = Solver.solve(P329.class, (Object) matrix);
        assertEquals(expected, actual);
    }
}