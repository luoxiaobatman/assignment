package com.luoxiaobatman.assignment.leetcode.binarytree;

import com.luoxiaobatman.assignment.leetcode.TreeNode;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import com.luoxiaobatman.assignment.util.TreeNodeUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P114Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "1,2,5,3,4,,6", "1,,2,,3,,4,,5,,6"
    })
    void doSolve(Integer[] table, Integer[] expected) {
        TreeNode root = Solver.solve(P114.class, TreeNodeUtils.fromFullTable(table));
        assertArrayEquals(expected, TreeNodeUtils.toFullTable(root));
    }
}