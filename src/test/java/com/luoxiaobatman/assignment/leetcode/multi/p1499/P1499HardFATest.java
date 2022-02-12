package com.luoxiaobatman.assignment.leetcode.multi.p1499;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P1499HardFATest {

    @ParameterizedTest
    @SolutionSource(value = {
            "1|3,2|0,5|10,6|-10", "1", "4"
    })
    void doSolve(int[][] points, Integer k, Integer expected) {
        Integer actual = Solver.solve(P1499HardFA.class, points, k);
        assertEquals(expected, actual);
    }
}
