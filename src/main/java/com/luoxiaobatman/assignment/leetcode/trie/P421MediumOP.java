package com.luoxiaobatman.assignment.leetcode.trie;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

/**
 * 字典树
 *
 * 从高位到低位 0 / 1 构建字典树, 一遍构建一遍找最大值
 *
 * O(32N) O(N)
 *
 * <a href="https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/">数组中两个数的最大异或值</a>
 */
@AllArgsConstructor
public class P421MediumOP extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[] nums;
    private final int MAX_BIT = 30;
    private final int LEFT = 0;
//    private final int RIGHT = 1;

    @Override
    public Integer doSolve() {
        return findMaximumXOR(nums);
    }

    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        int max = 0;
        for (int num : nums) {
            add(root, num);
            max = Math.max(check(root, num), max);
        }
        return max;
    }

    private int check(Trie root, int num) {
        int result = 0;
        Trie cur = root;
        for (int i = MAX_BIT; i > -1 ; i--) {
            int v = (num >> i) & 1;
            if (v == LEFT) {
                if (cur.right != null) {
                    result += (1 << i);
                    cur = cur.right;
                } else if (cur.left != null) {
                    cur = cur.left;
                }
            } else {
                if (cur.left != null) {
                    result += (1 << i);
                    cur = cur.left;
                } else if (cur.right != null) {
                    cur = cur.right;
                }
            }
        }
        return result;
    }

    private void add(Trie root, int num) {
        Trie cur = root;
        for (int i = MAX_BIT; i > -1 ; i--) {
            int v = (num >> i) & 1;
            if (v == LEFT) {
                if (cur.left == null) {
                    cur.left = new Trie();
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new Trie();
                }
                cur = cur.right;
            }
        }
    }

    private static class Trie {
        Trie left;
        Trie right;
    }
}
