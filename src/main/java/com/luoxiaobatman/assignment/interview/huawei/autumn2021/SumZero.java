package com.luoxiaobatman.assignment.interview.huawei.autumn2021;

import java.util.*;

/**
 * 一组整数, 选择3个数, 使他们的和等于0
 * 思路1: 暴力解法(略)
 * 思路2: meet in the middle
 *
 */
public class SumZero {
    private int[] ints;

    /**
     * O(n^3)
     */
    public List<int[]> brutalForceSumZero() {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (i == j) continue;
                for (int k = 0; k < ints.length; k++) {
                    if (i == k || j == k) continue;
                    if (ints[i] + ints[j] + ints[j] == 0) {
                        result.add(new int[] {ints[i], ints[j], ints[k]});
                    }
                }
            }
        }
        return result;
    }

    /**
     * O((n/2)^3)
     */
    public List<int[]> meetInTheMiddleSumZero() {
        List<int[]> result = new ArrayList<>();
        if (this.ints.length < 3) return null;
        int[] ints = Arrays.copyOf(this.ints, this.ints.length);
        Arrays.sort(ints);
        int middle = ints.length / 2;
        int[] left = Arrays.copyOfRange(ints, 0, middle);
        int[] right = Arrays.copyOfRange(ints, middle, ints.length);
        // 有以下四种情况
        // left里面3个的和为0
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < left.length; j++) {
                for (int k = 0; k < left.length; k++) {
                    // 和brutalForce相同
                }
            }
        }
        Set<Integer> rightSet = new HashSet<>();
        for (int i = 0; i < right.length; i++) {
            rightSet.add(-right[i]);
        }
        // left里面2个的和 = right里面1个的负数
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < left.length; j++) {
                if (i == j) continue;
                if (rightSet.contains(left[i] + left[j])) {
                    result.add(new int[] {left[i], left[j], -left[i] - left[j]});
                }
            }
        }

        // left里面1个 = right里面2个的和 的负数


        // right里面3个的和为0
        for (int i = 0; i < right.length; i++) {
            for (int j = 0; j < right.length; j++) {
                for (int k = 0; k < right.length; k++) {
                    // 和brutalForce相同
                }
            }
        }
        return result;
    }
}
