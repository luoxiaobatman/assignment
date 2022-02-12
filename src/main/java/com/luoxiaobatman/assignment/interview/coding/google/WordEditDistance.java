package com.luoxiaobatman.assignment.interview.coding.google;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

/**
 * TODO luoxiao
 *
 * dp问题
 * dp[i][j] 表示 A前i个字符 到B前j个字符的编辑距离
 * dp[0][j] = 0 dp[i][0] = 0
 * dp[i][j]
 *
 * 两个字符串 source 和 targedt
 * 将 source -> target 最小的步
 * 你可以:
 * 在任意位置插入一个字符
 * 在任意位置删除一个字符
 * 在任意位置改变一个字符
 * <p>
 * 以上均视为一步
 * <p>
 * 要求总步数最少
 * <p>
 * 别怕, 想去google就得一眼看出解法
 * <p>
 * 并且基本上做到bug free
 */
@AllArgsConstructor
public class WordEditDistance
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    @Override
    public Integer doSolve() {
        return null;
    }
}
