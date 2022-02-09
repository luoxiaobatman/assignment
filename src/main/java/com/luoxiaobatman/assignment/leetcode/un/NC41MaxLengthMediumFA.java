package com.luoxiaobatman.assignment.leetcode.un;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

/**
 * First Attempt 双指针
 *
 * 空间复杂度 O(n) 时间复杂度 O(n)
 *
 * 牛客
 */
@AllArgsConstructor
public class NC41MaxLengthMediumFA extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[] arr;

    @Override
    public Integer doSolve() {
        return maxLength(arr);
    }

    // ============= new coder =============
    public int maxLength (int[] arr) {
        // 后指针
        int end = 0;

        // 前指针
        int front = 0;

        int length = 0;
        int maxLength = length;

        int[] record = new int[100000 + 1];

        while (end < arr.length) {
            int value = arr[end];
            record[value]++;
            if (record[value] == 1) {
                length++;
                maxLength = Math.max(length, maxLength);
            } else {
                while (record[arr[front]] != 2) {
                    record[arr[front]]--;
                    length--;
                    front++;
                }
                record[arr[front]]--;
                front++;
            }
            end++;
        }

        return maxLength;
    }
}
