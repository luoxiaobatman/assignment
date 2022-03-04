package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P85Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "1|0|1|0|0,1|0|1|1|1,1|1|1|1|1,1|0|0|1|0", "6"
    })
    void doSolve(int[][] source, Integer expected) {
        Integer actual = Solver.solve(P85.class, (Object) source);
        assertEquals(expected, actual);
    }
}