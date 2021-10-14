package com.luoxiaobatman.assignment.leetcode.trivial.famous;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import lombok.AllArgsConstructor;

/**
 * Knuth-Morris-Pratt
 * 字符串匹配
 *
 * score=3
 */
@AllArgsConstructor
public class KMP implements Solution {
    private final String source;
    private final String pattern;

    /**
     * O(m)
     * @return f
     */
    private int[] buildPatternTable() {
        assert pattern.length() > 2;

        return null;
    }

    @Override
    public Answer solve() {
        return null;
    }
}
