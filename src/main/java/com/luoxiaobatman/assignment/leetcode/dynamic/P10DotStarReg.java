package com.luoxiaobatman.assignment.leetcode.dynamic;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

/**
 * 预处理
 * 合并连续的*
 * <p>
 * 正则表达式 . * 的实现
 * dp值为true or false
 * dp, n表示p的下标, m表示source的下标
 * S(n, m) = if p[n] = *, S(n - 1, m), S(n - 2, m - 1)...
 * <p>
 * S(n) = if n是*, S(n - 1)做笛卡尔积, 增加状态数
 * if n是., 同(n - 1), source右平移1, 状态数不变
 * if n是c, 减少状态, 减少状态
 */
@AllArgsConstructor
public class P10DotStarReg implements Solution {
    private final String source;
    private final String pattern;

    @Override
    public Answer solve() {
        int len = source.length();
        List<Integer> state = new ArrayList<>();
        if (pattern.charAt(0) == '*') {
            state.add(0);
        } else if (pattern.charAt(0) == '.') {
            state.add(1);  // 从1(inclusive)开始的子字符串
        } else {
            if (pattern.charAt(0) == source.charAt(0)) {
                state.add(1);
            }
        }
        List<Integer>[] dp = new ArrayList[pattern.length()];

        dp[0] = state;
        int i = 1;
        for (; i < pattern.length(); i++) {
            if (dp[i - 1].isEmpty()) {
                break;
            } else {
                // 状态转移方程
                if (pattern.charAt(i) == '*') {
                    Integer first = dp[i - 1].get(0);
                    List<Integer> newState = new ArrayList<>();
                    newState.add(-Math.abs(first));
                    dp[i] = newState;
                } else if (pattern.charAt(i) == '.') {
                    List<Integer> newState = new ArrayList<>();
                    dp[i] = newState;
                    Integer first = dp[i - 1].get(0);
                    if (first <= 0) {
                        newState.add(first - 1);
                    } else {
                        for (Integer integer : dp[i - 1]) {
                            if (integer < len)
                                newState.add(integer + 1);
                        }
                    }
                } else {
                    List<Integer> newState = new ArrayList<>();
                    dp[i] = newState;
                    Integer first = dp[i - 1].get(0);
                    if (first <= 0) {
                        for (int j = -first; j < len - 1; j++) {
                            if (source.charAt(j) == pattern.charAt(i)) {
                                newState.add(j + 1);
                            }
                        }
                    } else {
                        for (Integer integer : dp[i - 1]) {
                            if (integer < len) {
                                newState.add(integer + 1);
                            }
                        }
                    }
                }
            }
        }
        state = dp[i - 1];
        boolean flag = false;
        if (state == null || state.isEmpty()) {
            flag = false;
        } else {
            Integer last = state.get(state.size() - 1);
            if (last <= 0 || last == len) {
            } else {
                if (pattern.endsWith("*")) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        }
        return Factory.of(Answer.class).newInstance(flag);
    }
}
