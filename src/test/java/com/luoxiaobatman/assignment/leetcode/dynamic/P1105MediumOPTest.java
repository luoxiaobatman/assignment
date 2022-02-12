package com.luoxiaobatman.assignment.leetcode.dynamic;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P1105MediumOPTest {

    @ParameterizedTest
    @SolutionSource(value = {
        "1|1,2|3,2|3,1|1,1|1,1|1,1|2", "4", "6"
    })
    void doSolve(int[][] books, Integer shelfWidth,  Integer expected) {
        Integer actual = Solver.solve(P1105MediumOP.class, books, shelfWidth);
        assertEquals(expected, actual);
    }
}