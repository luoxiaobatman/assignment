package com.luoxiaobatman.assignment.leetcode.binarytree;

import com.luoxiaobatman.assignment.leetcode.TreeNode;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import com.luoxiaobatman.assignment.util.TreeNodeUtils;
import lombok.AllArgsConstructor;

import java.util.LinkedList;

@AllArgsConstructor
public class P98
        extends AbstractSolution<Boolean> implements GenericSolution<Boolean> {
    private final Integer[] fullTree;
    @Override
    public Boolean doSolve() {
        TreeNode root = TreeNodeUtils.fromFullTable(fullTree);
        return isValidBST(root);
    }

    public boolean isValidBST(TreeNode root) {
        try {
            postOrderRecursive(root);
        } catch (NotBST ignored) {
            return false;
        }
        return true;
    }

    private Holder postOrderRecursive(TreeNode root) throws NotBST {
        Holder leftHolder;
        if (root.left == null) {
            leftHolder = new Holder();
            leftHolder.min = Integer.MAX_VALUE;
            leftHolder.max = Integer.MIN_VALUE;
        } else {
            leftHolder = postOrderRecursive(root.left);
            if (root.val <= leftHolder.max) {
                throw new NotBST();
            }
        }

        Holder rightHolder;
        if (root.right == null) {
            rightHolder = new Holder();
            rightHolder.min = Integer.MAX_VALUE;
            rightHolder.max = Integer.MIN_VALUE;
        } else {
            rightHolder = postOrderRecursive(root.right);
            if (root.val >= rightHolder.min) {
                throw new NotBST();
            }
        }

        Holder holder = rightHolder;
        holder.min = Math.min(holder.min, Math.min(root.val, leftHolder.min));
        holder.max = Math.max(holder.max, Math.max(root.val, leftHolder.max));
        return holder;
    }

    private static class Holder {
        int min;
        int max;
    }

    private static class NotBST extends Exception {}
}
