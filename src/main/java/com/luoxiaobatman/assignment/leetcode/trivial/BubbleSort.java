package com.luoxiaobatman.assignment.leetcode.trivial;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * 面试做不出来, 就做不出来吧. LOL
 *
 * <a href="https://zhuanlan.zhihu.com/p/42586566">Trivial</a>
 * 冒泡trivial, scores=1
 *
 * @implNote 时间复杂度avg:O(n^2)
 * 空间复杂度O(1)
 * stable
 * 对完全有序的数组O(n)
 * @apiNote 无适用范围
 */
@AllArgsConstructor
public class BubbleSort implements Solution {
    @Override
    public Answer solve() {
        final int[] ints = Arrays.copyOf(this.ints, this.ints.length);

        for (int i = 0; i < ints.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < ints.length - i - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    xorSwap(ints, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        return Factory.of(Answer.class).newInstance(ints);
    }

    private final int[] ints;

    private void xorSwap(int[] ints, int i, int j) {
        assert i >= 0;
        assert j >= 0;
        ints[i] ^= ints[j];
        ints[j] ^= ints[i];
        ints[i] ^= ints[j];
    }
}
