package com.luoxiaobatman.assignment.leetcode.foryou;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;

import java.util.Arrays;

/**
 * 单调栈解法
 *
 * m列n行
 * worst: 时间复杂度 O((mn)^2)
 * avg: 时间复杂度 ???
 * 空间复杂度: O(mn)
 * scores=10
 * bonus多线程: 3
 * bonus单元测试: 5
 * <p>
 *     为题描述:
 *     给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。
 * </p>
 */
public class P2154Improved implements Solution {
    @Override
    public Answer solve() {
        int n = 7;
        String[] source = {
                "0101100",
                "1101111",
                "0011111"
        };

        Integer[][] intss = Arrays.stream(source).map(s -> {
            return Arrays.stream(s.split("")).map(Integer::parseInt).toArray(Integer[]::new);
        }).toArray(Integer[][]::new);
        int size = intss.length;

        int maxArea = 0;

        for (int i = 0; i < size; i++) {
            Integer[][] subInts = new Integer[size - i][n];
            subInts[0] = intss[i];
            int subMaxArea = maxArea(subInts[0]);
            for (int j = i + 1; j < size; j++) {
                final int debricIndex = j - i;
                Arrays.setAll(subInts[debricIndex], index -> {
                    if (subInts[debricIndex - 1][index] > 0 && intss[debricIndex][index] > 0) {
                        return subInts[debricIndex - 1][index] + 1;
                    }
                    return 0;
                });
                int subSubMaxArea = maxArea(subInts[debricIndex]);
                if (subSubMaxArea == 0) break;
                subMaxArea = Math.max(subMaxArea, subSubMaxArea);
                // 问题转换为直方图最大矩形面积 @see
                // 找到直方图 subInts[j]的最大矩形面积
                // 假如为0, 快速返回
            }
            maxArea = Math.max(maxArea, subMaxArea);
        }

        Answer answer = Factory.of(Answer.class).newInstance();
        answer.setAnswer(maxArea);
        return answer;
    }

    /**
     * 暴力
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     * 直方图最大矩形面积
     * @param ints 直方图
     * @return 最大面积
     */
    private int maxArea(Integer[] ints) {
        int maxArea = 0;
        for (int i = 0; i < ints.length; i++) {
            int subMaxAreaHeight = ints[i];
            int subMaxArea = ints[i];
             for (int j = i + 1; j < ints.length; j++) {
                 int height = Math.min(subMaxAreaHeight, ints[j]);
                 if (height == 0) break;
                 if (height * (j - i + 1) > subMaxArea) {
                     subMaxArea = height * (j - i + 1);
                     subMaxAreaHeight = height;
                 }
            }
            maxArea = Math.max(maxArea, subMaxArea);
        }
        return maxArea;
    }

    /**
     *
     * 4 1 2 3 5
     * stack: -1 1 2 3
     * max: 4
     * @param ints
     * @return
     */
    private int maxAreaImproved(Integer[] ints) {
        int maxArea = 0;
        for (int i = 0; i < ints.length; i++) {
            int subMaxAreaHeight = ints[i];
            int subMaxArea = ints[i];
             for (int j = i + 1; j < ints.length; j++) {
                 int height = Math.min(subMaxAreaHeight, ints[j]);
                 if (height == 0) break;
                 if (height * (j - i + 1) > subMaxArea) {
                     subMaxArea = height * (j - i + 1);
                     subMaxAreaHeight = height;
                 }
            }
            maxArea = Math.max(maxArea, subMaxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = Factory.of(Solution.class).newInstance(P2154.class);
        solution.solve();
    }
}
