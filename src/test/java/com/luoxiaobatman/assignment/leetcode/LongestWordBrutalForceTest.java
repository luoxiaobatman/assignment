package com.luoxiaobatman.assignment.leetcode;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;

class LongestWordBrutalForceTest {


    @ParameterizedTest
    @SolutionSource(value = {
            "abc,a,b,c", "abc",
            "a,abc,a,b,c", "abc",
            "a,abc,a,b,c", "abc",
    })
    void doSolve(String[] words, String expected) {
        String actual = Solver.solve(LongestWordBrutalForce.class, (Object) words);
        Assertions.assertEquals(expected, actual);
    }
}