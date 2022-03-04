package com.luoxiaobatman.assignment.leetcode.binarytree;

import com.luoxiaobatman.assignment.leetcode.TreeNode;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;

import java.util.HashMap;
import java.util.Map;

public class P105
        extends AbstractSolution<TreeNode> implements GenericSolution<TreeNode> {
    public P105(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
    }

    private int[] preorder;
    private int[] inorder;

    @Override
    public TreeNode doSolve() {
        return buildTree(preorder, inorder);
    }

    private Map<Integer, Integer> inorderIntToIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIntToIndex = new HashMap<>();
        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < inorder.length; i++) {
            inorderIntToIndex.put(inorder[i], i);
        }

        return findRoot(0, 0, preorder.length);
    }

    private TreeNode findRoot(int preorderStart, int inorderStart, int length) {
        if (length <= 0) return null;
        TreeNode root = new TreeNode(preorder[preorderStart]);
        int split = inorderIntToIndex.get(root.val);
        int leftLength = split - inorderStart;
        int leftStart = preorderStart + 1;
        root.left = findRoot(leftStart, inorderStart, leftLength);

        root.right = findRoot(
                leftStart + leftLength,
                inorderStart + leftLength + 1,
                length - leftLength - 1
        );
        return root;
    }
}
