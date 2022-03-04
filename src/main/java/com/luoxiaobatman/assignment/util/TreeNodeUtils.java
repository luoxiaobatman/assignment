package com.luoxiaobatman.assignment.util;

import com.luoxiaobatman.assignment.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtils {
    public static TreeNode fromFullTable(Integer[] table) {
        TreeNode root = new TreeNode(table[0]);
        fillRoot(root, table, 0);
        return root;
    }

    public static Integer[] toFullTable(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            TreeNode poll = q.poll();
            if (poll != null) {
                result.add(poll.val);
                q.offer(poll.left);
                q.offer(poll.right);
            } else {
                result.add(null);
            }
        }
        for (int i = result.size() - 1; i > -1; i--) {
            if (result.get(i) == null) {
                result.remove(i);
            } else {
                break;
            }
        }
        return result.toArray(new Integer[0]);
    }

    private static void fillRoot(TreeNode root, Integer[] table, int i) {
        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;
        if (leftIndex < table.length) {
            if (table[leftIndex] != null) {
                root.left = new TreeNode(table[leftIndex]);
                fillRoot(root.left, table, leftIndex);
            }
        }
        if (rightIndex < table.length) {
            if (table[rightIndex] != null) {
                root.right = new TreeNode(table[rightIndex]);
                fillRoot(root.right, table, rightIndex);
            }
        }
    }
}
