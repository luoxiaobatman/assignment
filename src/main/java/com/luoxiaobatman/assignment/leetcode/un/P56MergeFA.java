package com.luoxiaobatman.assignment.leetcode.un;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * starts 建立最小堆或者排序, 将相邻的first的end和second的start比较, 相交即合并. 遍历
 * 时间 O(nlogn) 空间 O(n)
 *
 *
 * <a href="https://leetcode-cn.com/problems/merge-intervals/">Q</a>
 */
public class P56MergeFA
        extends AbstractSolution<int[][]> implements GenericSolution<int[][]> {
    @Override
    public int[][] doSolve() {
        return new int[0][];
    }
}
