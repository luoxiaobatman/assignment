package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P210Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "2", "1|0", "0,1"
    })
    void doSolve(Integer num, int[][] prerequisites, int[] expected) {
        int[] actual = Solver.solve(P210.class, num, prerequisites);
        assertArrayEquals(expected, actual);
    }
}