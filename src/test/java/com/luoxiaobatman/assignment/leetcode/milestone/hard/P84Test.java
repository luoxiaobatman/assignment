package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P84Test {

    @ParameterizedTest
    @SolutionSource(value = {
        "2,1,5,6,2,3", "10",
        "2,4", "4",
        "7,6", "12",
    })
    void doSolve(int[] sources, Integer expected) {
        Integer actual = Solver.solve(P84.class, (Object) sources);
        assertEquals(expected, actual);
    }
}