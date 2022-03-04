package com.luoxiaobatman.assignment.leetcode.milestone.spring2022;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P000Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "1,2,3,2,3", "1",
            "2,3,2,3,1", "1",
    })
    void doSolve(int[] sources, Integer expected) {
        Integer actual = Solver.solve(P000.class, sources);
        assertEquals(expected, actual);
    }
}