package com.luoxiaobatman.assignment.leetcode.trivial;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * <a href="https://zhuanlan.zhihu.com/p/42586566">Trivial</a>
 * 归并trivial+, scores=2
 *
 * @implNote
 * 数组实现
 * 时间复杂度avg:O(nlogn)
 * 空间复杂度O(n)
 * stable
 *
 * @apiNote 空间复杂度较高
 */
@AllArgsConstructor
public class MergeSort implements Solution {
    private final int[] ints;

    @Override
    public Answer solve() {
        int[] result = mergeSort(ints);
        return Factory.of(Answer.class).newInstance(result);
    }

    /**
     * @param ints 数组
     * @return 排序好的数组
     */
    private int[] mergeSort(int[] ints) {
        // TODO 查阅文献, 不同大小的数组应该用哪种算法最合适
        if (ints.length == 1) {
            return ints;
        }
        if (ints.length == 2) {
            if (ints[0] > ints[1]) {
                xorSwap(ints, 0, 1);
            }
            return ints;
        } else {
            int[] lefts = Arrays.copyOfRange(ints,0, ints.length / 2);
            int[] rights = Arrays.copyOfRange(ints, ints.length / 2, ints.length);
            int[] result = new int[lefts.length + rights.length];
            result[result.length - 1] = 1 << 31;
            lefts = mergeSort(lefts);
            rights = mergeSort(rights);
            int i = 0;
            int j = 0;

            while (i != lefts.length || j != rights.length) {
                int left;
                try {
                    left = lefts[i];
                } catch (IndexOutOfBoundsException e) {
                    result[i + j] = rights[j];
                    j++;
                    continue;
                }
                int right;
                try {
                    right = rights[j];
                } catch (IndexOutOfBoundsException e) {
                    result[i + j] = lefts[i];
                    i++;
                    continue;
                }
                if (left <= right) {
                    result[i + j] = left;
                    i++;
                } else {
                    result[i + j] = right;
                    j++;
                }
            }
            return result;
        }
    }

    private void xorSwap(int[] ints, int i, int j) {
        assert i >= 0;
        assert j >= 0;
        ints[i] ^= ints[j];
        ints[j] ^= ints[i];
        ints[i] ^= ints[j];
    }
}
