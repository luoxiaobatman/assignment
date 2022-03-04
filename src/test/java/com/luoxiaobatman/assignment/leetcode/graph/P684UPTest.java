package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P684UPTest {

    @ParameterizedTest
    @SolutionSource(value = {
            "1|2,1|3,2|3", "2,3"
    })
    void doSolve(int[][] edges, int[] expected) {
        int[] actual = Solver.solve(P684UP.class, (Object) edges);
        assertArrayEquals(expected, actual);;
    }
}