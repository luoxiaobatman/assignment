package com.luoxiaobatman.assignment.leetcode.binarytree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 右到左广度优先遍历, 遇到下一层的第一个节点标注
 *
 * <a href="https://leetcode-cn.com/problems/WNC0Lk/">二叉树的右侧视图</a>
 */

public class Offer2P46FA {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Queue<Object> q = new LinkedList<>();
        q.offer(root);
        q.offer(0);
        TreeNode next;
        TreeNode[] result = new TreeNode[100];

        while ((next = (TreeNode) q.poll()) != null) {
            int level = (int) q.poll();

            if (result[level] == null) {
                result[level] = next;
            }
            if (next.right != null) {
                q.offer(next.right);
                q.offer(level + 1);
            }
            if (next.left != null) {
                q.offer(next.left);
                q.offer(level + 1);
            }
        }
        return Arrays.stream(result).filter(Objects::nonNull)
                .map(node -> node.val).collect(Collectors.toList());
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
