package com.luoxiaobatman.assignment.leetcode.foryou;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;

import java.util.Arrays;
import java.util.Stack;

/**
 * 暴力解法
 * 单调栈法
 * <p>
 * m列n行
 * worst: 时间复杂度 O((mn)^2)
 * avg: 时间复杂度 ???
 * 空间复杂度: O(mn)
 * scores=10
 * bonus多线程: 3
 * bonus单元测试: 5
 * <p>
 * 为题描述:
 * 给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。
 * </p>
 */
public class P2154 implements Solution {
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
            int subMaxArea = maxAreaImproved(subInts[0]);
            for (int j = i + 1; j < size; j++) {
                final int debricIndex = j - i;
                // TODO bit位表示, 并运算, 最后的值为debricIndex
                Arrays.setAll(subInts[debricIndex], index -> {
                    if (subInts[debricIndex - 1][index] > 0 && intss[debricIndex][index] > 0) {
                        return subInts[debricIndex - 1][index] + 1;
                    }
                    return 0;
                });
                int subSubMaxArea = maxAreaImproved(subInts[debricIndex]);
                if (subSubMaxArea == 0) break;
                subMaxArea = Math.max(subMaxArea, subSubMaxArea);
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
     *
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
     * 单调栈方法
     * 核心思想, stack维护ints下标i, ints[stack.pop()] 单调递减
     * ints循环,
     * 如果循环体中 ints[stack.peek()] 大于等于 ints[i]
     *     while 出栈, 计算最大面积, 利用stack单调递增的特性
     * 最后处理stack中的剩余值
     *
     * @param ints 直方图
     * @return 最大面积
     */
    private int maxAreaImproved(Integer[] ints) {
        ints = Arrays.copyOf(ints, ints.length);
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < ints.length; i++) {
            int peek = stack.peek();
            while (peek != -1 && ints[i] <= ints[peek]) {
                int height = ints[stack.pop()];
                peek = stack.peek();
                int width = i - peek + 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int pop = stack.pop();
            maxArea = Math.max(maxArea, ints[pop] * (ints.length - pop));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = Factory.of(Solution.class).newInstance(P2154.class);
        System.out.println(solution.solve());
    }
}
