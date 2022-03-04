package com.luoxiaobatman.assignment.leetcode.dynamic;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P96Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "3", "5"
    })
    void doSolve(Integer n, Integer expected) {
        Integer actual = Solver.solve(P96.class, n);
        assertEquals(expected, actual);
    }
}