package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.leetcode.ListNode;
import com.luoxiaobatman.assignment.leetcode.milestone.easy.P23;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import com.luoxiaobatman.assignment.util.ListNodeUtils;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P23Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "1|4|5,1|3|4,2|6", "1,1,2,3,4,4,5,6"
    })
    void doSolve(int[][] linkedLists, int[] expected) {
        ListNode[] listNodes = new ListNode[linkedLists.length];
        for (int i = 0; i < listNodes.length; i++) {
            listNodes[i] = ListNodeUtils.fromFullTable(linkedLists[i]);
        }

        ListNode solve = Solver.solve(P23.class, (Object) listNodes);
        assertArrayEquals(expected, ListNodeUtils.toFullTable(solve));
    }
}
