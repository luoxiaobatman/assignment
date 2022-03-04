package com.luoxiaobatman.assignment.leetcode.milestone.spring2022;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P001Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "1,2,2", "2",
            "1,2,3,4,4,4,4", "4",
    })
    void doSolve(int[] sources, Integer expected) {
        Integer actual = Solver.solve(P001.class, (Object) sources);
        assertEquals(expected, actual);
    }
}
