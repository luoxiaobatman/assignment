package com.luoxiaobatman.assignment.leetcode.game;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P294OPTest {

    @ParameterizedTest
    @SolutionSource(value = {
            "++--++---", "False"
    })
    void doSolve(String source, Boolean expected) {
        Boolean actual = Solver.solve(P294OP.class, source);
        assertEquals(expected, actual);
    }
}