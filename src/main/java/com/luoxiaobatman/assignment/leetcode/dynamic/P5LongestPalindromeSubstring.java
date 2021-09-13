package com.luoxiaobatman.assignment.leetcode.dynamic;


import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 * 最长回文子串
 * 动态规划 score=3
 * 中心扩展 score=1
 *
 * 中心扩展的多线程实现 score=1
 */
@AllArgsConstructor
public class P5LongestPalindromeSubstring implements Solution {
    private final String source;

    /**
     * 中心扩展
     * max O(n^2)
     * avg O(n)
     */
//    private String quick(String s) {
//        int longest = 1;
//        int center = 0;
//        int value = 1;
//        int len = s.length();
//        int gap = 0;
//        Map<Integer, Integer> centers = new HashMap<>(len);
//        int lastIndex = 0;
//        char lastValue = s.charAt(0);
//        centers.put(lastIndex, 1);
//        for (int i = 1; i < len; i++) {
//            if (s.charAt(i) == lastValue) {
//                int next = centers.get(i) + 1;
//                longest = Math.max(longest, next);
//                centers.put(lastIndex, next);
//            } else {
//                centers.put(i, 1);
//                lastValue = s.charAt(i);
//                lastIndex = i;
//            }
//        }
//        while ((gap++) < len / 2 + 1) {
//            List<Integer> removedKey = new ArrayList<>();
//            for (Map.Entry<Integer, Integer> e : centers.entrySet()) {
//                Integer key = e.getKey();
//                Integer value = e.getValue();
//                try {
//                    char front = s.charAt(key - gap);
//                    char end = s.charAt(key + value - 1 + gap);
//                    if (front != end) {
//                        if (longest < (gap - 1) * 2 + value) {
//                            longest = (gap - 1) * 2 + value;
//                            center = key;
//                        }
//                        removedKey.add(key);
//                    }
//                } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
//                    if (longest < (gap - 1) * 2 + value) {
//                        longest = (gap - 1) * 2 + value;
//                        center = key;
//                    }
//                    removedKey.add(key);
//                }
//            }
//            for (Integer remove : removedKey) {
//                centers.remove(remove);
//            }
//        }
//
//
//        return s.substring(center - longest / 2, center + longest / 2 + 1);
//    }

    /**
     * 动态规划
     * 时间:O(n^2)
     * 空间:O(n^2)
     *
     * n: 表示子串长度 - 1
     * m: 表示子串开始下标
     * 数组存储最大回文长度
     * arr[n][m] = max(conditional arr[n-2][m-1] + 2, arr[n-1][m], arr[n-1][m+1])
     *
     * @implNote
     * 1. dp[0][] dp[1][] 提前构建
     * 2. beginning是最大回文长度字符串的起始下标
     */
    private String dynamic() {
        char[] chars = source.toCharArray();

        int beginning = 0;
        int len = chars.length;
        int[][] dp = new int[len][len];
        int[] start = new int[len];
        Arrays.fill(start, 1);
        dp[0] = start;
        for (int i = 0; i < len - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                dp[1][i] = 2;
                beginning = i;
            } else {
                dp[1][i] = 1;
            }
        }

        for (int n = 2; n < len; n++) {
            for (int m = 0; m < len - n; m++) {
                if (chars[m] == chars[m + n] && dp[n - 2][m + 1] == n - 1) {
                    dp[n][m] = dp[n - 2][m + 1] + 2;
                    beginning = m;
                } else {
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n - 1][m + 1]);
                }
            }
        }
        int palindromeLen = dp[len - 1][0];
        return source.substring(beginning, beginning + palindromeLen);
    }

    @Override
    public Answer solve() {
        return Factory.of(Answer.class).newInstance(dynamic());
    }
}
