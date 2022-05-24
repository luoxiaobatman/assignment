package com.luoxiaobatman.assignment.leetcode.binarytree;

import java.util.*;

/**
 * <a href="https://leetcode-cn.com/problems/WNC0Lk/">二叉树的右侧视图</a>
 */

public class Offer2P46FA {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Queue<TreeNode> queueWaitingToBeScanned = new LinkedList<>();
        Queue<TreeNode> nextLevelNodes = new LinkedList<>();
        queueWaitingToBeScanned.offer(root);
        TreeNode next;
        List<Integer> result = new ArrayList<>();

        while ((next = queueWaitingToBeScanned.poll()) != null) {
            result.add(next.val);
            do {
                if (next.right != null) {
                    nextLevelNodes.offer(next.right);
                }
                if (next.left != null) {
                    nextLevelNodes.offer(next.left);
                }
            } while ((next = queueWaitingToBeScanned.poll()) != null);
            queueWaitingToBeScanned = nextLevelNodes;
            nextLevelNodes = new LinkedList<>();
        }
        return result;
    }

    private static class TreeNode {
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
