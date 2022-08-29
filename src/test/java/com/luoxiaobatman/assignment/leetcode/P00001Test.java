package com.luoxiaobatman.assignment.leetcode;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P00001Test {
    @ParameterizedTest
    @SolutionSource(value = {
            "1,2,3"
    })
    void testSolution(String[] values) {
        Boolean solve = Solver.solve(P00001.class);
        assertNull(solve);
    }
}