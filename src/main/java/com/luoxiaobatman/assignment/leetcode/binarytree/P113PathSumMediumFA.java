package com.luoxiaobatman.assignment.leetcode.binarytree;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

/**
 * 深度优先, 后续遍历
 *
 * <a href="https://leetcode-cn.com/problems/path-sum-ii/">路径总和 2</a>
 */
@AllArgsConstructor
public class P113PathSumMediumFA
        extends AbstractSolution<List<List<Integer>>> implements GenericSolution<List<List<Integer>>> {
    @Override
    public List<List<Integer>> doSolve() {
        return null;
    }

    // ============= leetcode ================

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return pathSum(root, 0, targetSum);
    }

    private List<List<Integer>> pathSum(TreeNode node, int pathSum, int targetSum) {
        List<List<Integer>> result = new LinkedList<>();
        if (node == null) return result;
        pathSum += node.val;
        if (node.left != null) {
            List<List<Integer>> leftPaths = pathSum(node.left, pathSum, targetSum);
            result.addAll(leftPaths);
        }
        if (node.right != null) {
            List<List<Integer>> rightPaths = pathSum(node.right, pathSum, targetSum);
            result.addAll(rightPaths);
        }

        // 叶子节点
        if (node.left == null && node.right == null) {
            if (pathSum == targetSum) {
                List<Integer> path = new LinkedList<>();
                path.add(node.val);
                result.add(path);
            }
        } else {
            for (List<Integer> path : result) {
                path.add(0, node.val);
            }
        }
        return result;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
