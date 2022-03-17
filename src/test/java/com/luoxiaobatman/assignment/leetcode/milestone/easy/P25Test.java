package com.luoxiaobatman.assignment.leetcode.milestone.easy;

import com.luoxiaobatman.assignment.leetcode.ListNode;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import com.luoxiaobatman.assignment.util.ListNodeUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P25Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "1,2,3,4,5", "2", "2,1,4,3,5",
            "1,2", "2", "2,1",
            "1,2", "3", "1,2",
            "1,2,3", "2", "2,1,3",
            "1,2,3,4", "3", "3,2,1,4",
            "1,2,3,4,5", "3", "3,2,1,4,5",
    })
    void doSolve(int[] ints, Integer k, int[] expected) {
        ListNode solve = Solver.solve(P25.class, ListNodeUtils.fromFullTable(ints), k);
        assertArrayEquals(expected, ListNodeUtils.toFullTable(solve));
    }
}
