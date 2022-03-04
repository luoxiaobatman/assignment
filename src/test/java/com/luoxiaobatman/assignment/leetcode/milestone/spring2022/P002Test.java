package com.luoxiaobatman.assignment.leetcode.milestone.spring2022;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P002Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "1|2|3,2|4|6,3|6|9", "3", "1",
    })
    void doSolve(int[][] matrix, Integer expected) {
        Integer actual = Solver.solve(P002.class, (Object) matrix);
        assertEquals(expected, actual);
    }
}