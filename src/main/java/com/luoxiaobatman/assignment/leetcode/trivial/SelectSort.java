package com.luoxiaobatman.assignment.leetcode.trivial;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * <a href="https://zhuanlan.zhihu.com/p/42586566">Trivial</a>
 * 选择trivial, scores=1
 *
 * @implNote
 * 时间复杂度avg:O(n^2)
 * 空间复杂度O(1)
 * unstable
 *
 * @apiNote
 * 无适用范围
 */
@AllArgsConstructor
public class SelectSort implements Solution {
    private final int[] ints;

    @Override
    public Answer solve() {
        final int[] ints = Arrays.copyOf(this.ints, this.ints.length);

        for (int i = 0; i < ints.length; i++) {
            int min = -1;
            int v = ints[i];
            for (int j = i; j < ints.length; j++) {
                if (v > ints[j]) {
                    v = ints[j];
                    min = j;
                }
            }
            if (min != -1) {
                xorSwap(ints, i, min);
            }
        }

        return Factory.of(Answer.class).newInstance(ints);
    }

    private void xorSwap(int[] ints, int i, int j) {
        assert i >= 0;
        assert j >= 0;
        ints[i] ^= ints[j];
        ints[j] ^= ints[i];
        ints[i] ^= ints[j];
    }
}
