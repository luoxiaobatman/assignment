package com.luoxiaobatman.assignment.leetcode.dfs;

import com.luoxiaobatman.assignment.support.IntArgumentsParser;
import com.luoxiaobatman.assignment.support.IntegersArgumentsParser;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P365Test {

    @ParameterizedTest
    @SolutionSource(value = {
        "2", "6", "5", "true"
    })
    void doSolve(Integer a, Integer b, Integer c, Boolean expected) {
        Boolean actual = Solver.solve(P365.class, a, b, c);
        assertEquals(expected, actual);
    }
}