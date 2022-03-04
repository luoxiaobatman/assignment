package com.luoxiaobatman.assignment.leetcode;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P10FATest {

    @ParameterizedTest
    @SolutionSource(value = {
//            "ab", "a", "0",
            "abc", "a*", "1",
            "abc", "a*d", "0",
            "aa", "a", "0",
            "aab", "c*a*b", "1",
    })
    void doSolve(String s, String p, Integer expected) {
        Integer actual = Solver.solve(P10FA.class, s, p);
        assertEquals(expected, actual);
    }
}
