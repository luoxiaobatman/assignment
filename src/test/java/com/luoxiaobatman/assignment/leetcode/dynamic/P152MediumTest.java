package com.luoxiaobatman.assignment.leetcode.dynamic;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P152MediumTest {

    @ParameterizedTest
    @SolutionSource(value = {
            "2,3,-2,4", "6",
    })
    void doSolve(int[] sources, Integer expected) {
        Integer actual = Solver.solve(P152Medium.class, (Object) sources);
        assertEquals(expected, actual);
    }
}