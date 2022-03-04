package com.luoxiaobatman.assignment.leetcode.binarytree;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P98Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "2,1,3", "true",
            "2147483647", "true",
    })
    void doSolve(Integer[] fullTree, Boolean expected) {
        Boolean actual = Solver.solve(P98.class, (Object) fullTree);
        assertEquals(expected, actual);
    }
}