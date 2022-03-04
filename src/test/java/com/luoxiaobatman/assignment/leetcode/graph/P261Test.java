package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P261Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "5", "0|1,0|2,0|3,1|4", "true",
//            "5", "0|1,1|2,2|3,1|3,1|4", "false",
    })
    void doSolve(Integer n, int[][] edges, Boolean expected) {
        Boolean actual = Solver.solve(P261.class, n, edges);
        assertEquals(expected, actual);
    }
}