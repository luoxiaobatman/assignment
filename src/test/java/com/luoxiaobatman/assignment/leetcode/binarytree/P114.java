package com.luoxiaobatman.assignment.leetcode.binarytree;

import com.luoxiaobatman.assignment.leetcode.TreeNode;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class P114
        extends AbstractSolution<TreeNode> implements GenericSolution<TreeNode> {
    private final TreeNode root;

    @Override
    public TreeNode doSolve() {
        flatten(root);
        return root;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            flatten(root.left);
        }

        // 中序, 将左子树覆盖右孩
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;

        if (right != null) {
            flatten(right);
        }

        // 找到叶子
        while (root.right != null) {
            root = root.right;
        }

        // 将右子树作为叶子的右孩
        root.right = right;
    }
}
