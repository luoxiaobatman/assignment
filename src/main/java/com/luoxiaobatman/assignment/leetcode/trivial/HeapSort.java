package com.luoxiaobatman.assignment.leetcode.trivial;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * <a href="https://zhuanlan.zhihu.com/p/42586566">Trivial</a>
 * 堆排序trivial, scores=1
 *
 * @implNote
 * 时间复杂度avg:O(nlogn)
 * 时间复杂度min:O(nlogn)
 * 时间复杂度max:O(n^2)
 * 空间复杂度O(1)
 * unstable
 *
 * @apiNote
 * 前n个最大数
 */
@AllArgsConstructor
public class HeapSort implements Solution {
    private final int[] source;

    @Override
    public Answer solve() {
        heapify();
        for (int i = source.length - 1; i > 0 ; i--) {
            Util.swap(source, 0, i);
            int root = 0;
            for (;;) {
                int swap = compareMaySwap(root, i);
                if (root == swap) break;
                root = swap;
            }
        }
        return Factory.of(Answer.class).newInstance(source);
    }

    /**
     * 从叶往根
     * 将source变成一个最大堆
     *
     * 调整source上下界之间为一个堆结构
     */
    private void heapify() {
        for (int i = 1; i < source.length; i++) {
            int current = i;
            int parent;
            while ((parent = parent(current)) >= 0) {
                if (source[current] <= source[parent]) break;
                Util.swap(source, current, parent);
                current = parent;
            }
        }
    }

    /**
     * TODO too verbose
     * 从根往叶
     *
     * @param i 父元素节点下标
     * @return swaped index, may return i, if nothing to compare
     */
    private int compareMaySwap(int i, int length) {
        // 左child
        int leftIndex = i * 2 + 1;
        if (leftIndex >= length) {
            return i;
        } else {
            int rightIndex = (i + 1) * 2;
            if (rightIndex >= length) {
                if (source[leftIndex] > source[i]) {
                    Util.swap(source, leftIndex, i);
                    return leftIndex;
                } else {
                    return i;
                }
            } else {
                if (source[leftIndex] > source[i]) {
                    if (source[rightIndex] > source[leftIndex]) {
                        Util.swap(source, i, rightIndex);
                        return rightIndex;
                    } else {
                        Util.swap(source, i, leftIndex);
                        return leftIndex;
                    }
                } else if (source[rightIndex] > source[i]) {
                    Util.swap(source, i, rightIndex);
                    return rightIndex;
                }
            }
        }
        return i;
    }

    /**
     * 找到节点的父下标
     * @param i 节点下标
     * @return 父下标
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }
}
