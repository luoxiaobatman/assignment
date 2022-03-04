package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P4UPTest {

    @ParameterizedTest
    @SolutionSource(value = {
            "1,3", "2", "2.0",
            "1,2", "3,4", "2.5",
            "3", "-2,-1", "-1",
            "3", "1,2", "2",
            "1", "2,3,4", "2.5",
            "2", "1,3,4", "2.5",
            "2,8", "1,3,4,5,6,7", "4.5",
            "1,4", "2,3,5,6,7", "4",
            "1,4,5", "2,3,6,7,8", "4.5",
            "4", "1,2,3", "2.5",
            "1", "2,3,4,5,6,7,8,9", "5.0",
            "2,2,4,4", "2,2,4,4", "3.0",
    })
    void doSolve(int[] nums1, int[] nums2, Double expected) {
        Double actual = Solver.solve(P4UP.class, nums1, nums2);
        assertEquals(expected, actual);
    }
}