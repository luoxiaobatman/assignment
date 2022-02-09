package com.luoxiaobatman.assignment.datastructure.string;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

/**
 * First Attempt, TODO luoxiao 进阶
 * <p>
 * KMP算法的pattern table构建
 * <p>
 * 返回数组, 两部分有意义, 下标i+值v
 * 下标表示pattern的子字符串(从0开始) 记为sub, sub.length()为下标i
 * 值表示sub的最大前缀=sub的后缀, 此最大前缀的长度记为v, 为数组下标i处的值
 * <p>
 * eg:
 * <p>
 * patter = "ababcadabd\00"
 * array = [-1, 0, 0, 1, 2, 0, 1, 0, 1, 2, 0]
 * <p>
 * pattern = "abababababcab\00"
 * array = [-1, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 0, 1, 2]
 */
@AllArgsConstructor
public class KMPPatternBuilderFA extends AbstractSolution<int[]> implements GenericSolution<int[]> {
    private final String pattern;

    @Override
    public int[] doSolve() {
        int[] patternTable = new int[pattern.length()];
        // 占位, 匹配了0个前缀是无意义的
        patternTable[0] = -1;

        // 匹配了1个前缀, 最短前缀为0
        patternTable[1] = 0;

        // 从2开始
        int subStringLength = 2;
        while (subStringLength < pattern.length()) {
            char subStringSuffix = pattern.charAt(subStringLength - 1);
            // 下一次要与suffix比较的下标
            int nextHit = patternTable[subStringLength - 1];
            while (nextHit > -1 && pattern.charAt(nextHit) != subStringSuffix) {
                nextHit = patternTable[nextHit];
            }
            patternTable[subStringLength] = nextHit + 1;
            subStringLength++;
        }

        return patternTable;
    }
}
