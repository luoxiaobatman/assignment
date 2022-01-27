package com.luoxiaobatman.assignment.leetcode.greedy;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

/**
 * 2**k 复杂度, 超时
 * <p>
 * 拼接最大数
 * <p>
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * <p>
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * <p>
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 * <p>
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 * <p>
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@AllArgsConstructor
public class P321HardSlow
        extends AbstractSolution<int[]> implements GenericSolution<int[]> {
    private int[] x;
    private int[] y;
    private int k;
    // xmap, ymap 然后greedy
    // Let there be light!

    @Override
    public int[] doSolve() {
        return createSlots(0, 0, this.k);
    }

    /**
     * @param xOffset  x偏移, 冻结低位
     * @param yOffset  y偏移
     * @param slotSize 填充量
     * @return 拼接最大数
     */
    private int[] createSlots(int xOffset, int yOffset, int slotSize) {
        int[] result = new int[slotSize];
        while (slotSize > 0) {
            int xResidualSize = x.length - xOffset;
            int yResidualSize = y.length - yOffset;

            int lowestEntropyXCut = Math.min(x.length,
                    x.length - Math.max(0, slotSize - yResidualSize) + 1);
            int lowestEntropyYCut = Math.min(y.length,
                    y.length - Math.max(0, slotSize - xResidualSize) + 1);

            Picked picked = greedy(xOffset, yOffset, lowestEntropyXCut, lowestEntropyYCut, slotSize);
            if (picked.xPicked && !picked.yPicked) {
                result[result.length - slotSize] = x[picked.xi];
                xOffset = picked.xi + 1;
                slotSize--;
            } else if (picked.yPicked && !picked.xPicked) {
                result[result.length - slotSize] = y[picked.yi];
                yOffset = picked.yi + 1;
                slotSize--;
            } else {
                result[result.length - slotSize] = x[picked.xi];
                slotSize--;
                // 转换为两个子问题
                int[] ints = createSlots(picked.xi + 1, yOffset, slotSize);
                int[] anotherInts = createSlots(xOffset, picked.yi + 1, slotSize);
                if (compare(ints, anotherInts) > 0) {
                    ints = anotherInts;
                }
                System.arraycopy(ints, 0,
                        result, result.length - slotSize,
                        slotSize);
                slotSize = 0;
            }
        }
        return result;
    }

    private Picked greedy(int xOffset, int yOffset, int xCut, int yCut, int slotSize) {
        Picked picked = new Picked();
        picked.xi = xOffset;
        picked.yi = yOffset;
        if (xOffset < x.length) {
            for (int i = xOffset + 1; i < xCut; i++) {
                if (x[i] > x[picked.xi]) {
                    picked.xi = i;
                }
            }
        }
        if (yOffset < y.length) {
            for (int i = yOffset + 1; i < yCut; i++) {
                if (y[i] > y[picked.yi]) {
                    picked.yi = i;
                }
            }
        }
        // y越界
        if (yOffset == y.length) {
            picked.xPicked = true;
            picked.yPicked = false;
            return picked;
        }
        // x越界
        if (xOffset == x.length) {
            picked.xPicked = false;
            picked.yPicked = true;
            return picked;
        }

        if (x[picked.xi] > y[picked.yi]) {
            picked.xPicked = true;
            picked.yPicked = false;
        } else if (x[picked.xi] < y[picked.yi]) {
            picked.xPicked = false;
            picked.yPicked = true;
        } else {
            // 上层决断
        }
        return picked;
    }

    private static class Picked {
        boolean xPicked;
        boolean yPicked;
        int xi;
        int yi;
    }

    private int compare(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] > y[i]) {
                return 0;
            }
            if (x[i] < y[i]) {
                return 1;
            }
        }
        return -1;
    }
}
