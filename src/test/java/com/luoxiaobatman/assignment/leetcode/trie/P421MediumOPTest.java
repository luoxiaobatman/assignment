package com.luoxiaobatman.assignment.leetcode.trie;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P421MediumOPTest {

    @ParameterizedTest
    @SolutionSource(value = {
            "1,2,3", "3",
    })
    void doSolve(int[] nums, Integer expected) {
        Integer actual = Solver.solve(P421MediumOP.class, (Object) nums);
        assertEquals(expected, actual);
    }
}