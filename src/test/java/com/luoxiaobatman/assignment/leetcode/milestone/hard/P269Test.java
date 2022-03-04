package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P269Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "wrt,wrf,er,ett,rftt", "wertf",
            "zy,zx", "zyx",
            "z,z", "z",
    })
    void doSolve(String[] words, String expected) {
        String actual = Solver.solve(P269.class, (Object) words);
        assertEquals(expected, actual);
    }
}
