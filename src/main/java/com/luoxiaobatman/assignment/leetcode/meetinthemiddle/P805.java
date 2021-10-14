package com.luoxiaobatman.assignment.leetcode.meetinthemiddle;

import com.luoxiaobatman.assignment.leetcode.trivial.Util;
import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *给定的整数数组 A ，我们要将 A数组 中的每个元素移动到 B数组 或者 C数组中。（B数组和C数组在开始的时候都为空）

返回true ，当且仅当在我们的完成这样的移动后，可使得B数组的平均值和C数组的平均值相等，并且B数组和C数组都不为空。
 A 数组的长度范围为 [1, 30].
A[i] 的数据范围为 [0, 10000].

 */
@AllArgsConstructor
public class P805 implements Solution {
    private final int[] source;

    @Override
    public Answer solve() {
        boolean result = false;

        final int len = source.length;
        final int sum = Arrays.stream(source).reduce(0, Integer::sum);
        int[] ints = Arrays.stream(source).map(num -> num * len - sum).toArray();
        Arrays.sort(ints);
        int half = len / 2;
        int[] left = Arrays.copyOfRange(ints, 0, half);
        int[] right = Arrays.copyOfRange(ints, half, len);
        int[] leftSubsetSum = Util.subsetSum(left);
        int[] rightSubsetSum = Util.subsetSum(right);

        int lastLeft = leftSubsetSum[leftSubsetSum.length - 1];
        int lastRight = rightSubsetSum[rightSubsetSum.length - 1];
        if (lastLeft == 0 || lastRight == 0) {
            result = true;
        } else {
            Set<Integer> leftSet = new HashSet<>();
            for (int i = 1; i < leftSubsetSum.length - 1; i++) {
                leftSet.add(-leftSubsetSum[i]);
            }
            if (leftSet.contains(lastRight) || leftSet.contains(0)) {
                result = true;
            } else {
                for (int i = 1; i < rightSubsetSum.length - 1; i++) {
                    int ele = rightSubsetSum[i];
                    if (leftSet.contains(ele) || ele == lastLeft || ele == 0) {
                        result = true;
                        break;
                    }
                }
            }
        }

        return Factory.of(Answer.class).newInstance(result);
    }
}
