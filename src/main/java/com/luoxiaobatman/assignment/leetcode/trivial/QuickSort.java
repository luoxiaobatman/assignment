package com.luoxiaobatman.assignment.leetcode.trivial;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import lombok.AllArgsConstructor;

/**
 * <a href="https://zhuanlan.zhihu.com/p/42586566">Trivial</a>
 * 快速排序trivial, scores=1
 *
 * @implNote
 * 时间复杂度avg:O(nlogn)
 * 时间复杂度min:O(nlogn)
 * 时间复杂度max:O(n^2)
 * 空间复杂度O(1)
 * unstable
 *
 * @apiNote
 * 适用范围广
 */
@AllArgsConstructor
public class QuickSort implements Solution {
    private final int[] source;

    @Override
    public Answer solve() {
        qsort(0, source.length);
        return Factory.of(Answer.class).newInstance(source);
    }

    /**
     * in-place sort
     * 维护一个局部变量cut
     * 小于等于pivot的集合S的上界
     *
     * @param lower 序列下标的下界, inclusive
     * @param upper 序列下标的上界, exclusive
     */
    private void qsort(int lower, int upper) {
        if (upper <= lower + 1) return;
        int pivot = source[lower];
        int cut = lower;

        for (int i = lower + 1; i < upper; i++) {
            if (source[i] <= pivot) {
                swap(cut + 1, i);
                cut++;
            }
        }

        swap(cut, lower);
        qsort(lower, cut);
        qsort(cut + 1, upper);
    }

    private void swap(int i, int j) {
        if (i == j) return;
        int tmp = source[i];
        source[i] = source[j];
        source[j] = tmp;
    }
}
