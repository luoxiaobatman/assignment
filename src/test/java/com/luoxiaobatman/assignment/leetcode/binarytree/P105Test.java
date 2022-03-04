package com.luoxiaobatman.assignment.leetcode.binarytree;

import com.luoxiaobatman.assignment.leetcode.TreeNode;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import com.luoxiaobatman.assignment.util.TreeNodeUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P105Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "3,9,20,15,7", "9,3,15,20,7", "3,9,20,,,15,7",
            "1,2", "2,1", "1,2"
    })
    void doSolve(int[] preorder, int[] inorder, Integer[] expected) {
        TreeNode root = Solver.solve(P105.class, preorder, inorder);
        Integer[] actual = TreeNodeUtils.toFullTable(root);
        assertArrayEquals(expected, actual);
    }
}