package com.luoxiaobatman.assignment.leetcode.named;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import lombok.AllArgsConstructor;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

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
     * String p = "ababaac";
     * char[] chars = p.toCharArray();
     *
     * int[] pt = new int[p.length()];
     * pt[0] = 0;
     * pt[1] = 0;
     *
     * 假设 pt[::n-1] 已知
     * 求 pt[n]
     * pt[n] = f(pt[::n-1]), 求f
     *
     * pt[n] = 0
     * int k = n - 1
     * while (k > 0) {
     *     if (chars[pt[k]] == chars[k]) { pt[n] = k + 1; break; }
     *     k = pt[k]
     * }
     *
     * O(m)
     * 最长suf-prefix子串, 定义数组 sufpre = int[]
     * 已知sufpre[::n-1], 求sufpre[n]
     * @return sufpre
     */
    private int[] buildPatternTable() {
        int len = pattern.length();
        assert len > 1;
        char[] chars = pattern.toCharArray();

        final int[] sufpre = new int[len];
        sufpre[0] = 0;
        sufpre[1] = 0;
//        sufpre[1] = chars[0] == chars[1] ? 1: 0;

        s: for (int i = 2; i < len; i++) {
            int k = i - 1;
            while (k > 0) {
                if (chars[i] == chars[sufpre[k]]) {
                    sufpre[i] = sufpre[k] +1;
                    continue s;
                }
                k = sufpre[k];
            }
            sufpre[i] = 0;
        }
        return sufpre;
    }

    @Override
    public Answer solve() {
        char[] chars = source.toCharArray();
        char[] pChars = pattern.toCharArray();
        final int pLen = pChars.length;
        int[] pt = buildPatternTable();
        int matched = 0;
        s: for (char c : chars) {
            if (c == pChars[matched]) {
                matched++;
                if (matched == pLen) {
                    break;
                }
            } else {
                matched = pt[matched];
                while (matched > 0) {
                    if (c == pChars[matched]) continue s;
                    matched = pt[matched];
                }
            }
        }
        return Factory.of(Answer.class).newInstance(matched == pLen);
    }
}
