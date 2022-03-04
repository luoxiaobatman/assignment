package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P310Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "4", "1|0,1|2,1|3", "1"
    })
    void doSolve(Integer n, int[][] edges, int[] expected) {
        int[] actual = Solver.solve(P310.class, n, edges);
        assertArrayEquals(expected, actual);
    }
}