package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P505DijkStraHeapTest {

    @ParameterizedTest
    @SolutionSource(value = {
            "0|0|1|0|0,0|0|0|0|0,0|0|0|1|0,1|1|0|1|1,0|0|0|0|0", "0,4", "4,4", "12",
    })
    void doSolve(int[][] maze, int[] start, int[] dst, Integer expected) {
        Integer actual = Solver.solve(P505DijkStraHeap.class, maze, start, dst);
        assertEquals(expected, actual);
    }
}