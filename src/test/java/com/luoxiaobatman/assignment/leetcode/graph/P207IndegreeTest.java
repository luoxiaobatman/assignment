package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P207IndegreeTest {

    @ParameterizedTest
    @SolutionSource(value = {
            "2", "1|0", "true",
            "2", "1|0,0|1", "false",
    })
    void doSolve(Integer num, int[][] prerequisites, Boolean expected) {
        Boolean actual = Solver.solve(P207Indegree.class, num, prerequisites);
        assertEquals(expected, actual);
    }
}