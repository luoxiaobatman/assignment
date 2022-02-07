package com.luoxiaobatman.assignment.leetcode.un;

/**
 * 双指针
 * <pre>
 *     指向左右两端点, 向内移动较小者, 移动后的柱子如果较小, 则sum += delta,
 *     如果较大, noop, 重新比较两端点, 直到相遇
 * </pre>
 * 复杂度: O(n), O(1)
 *
 * 单调栈
 * <pre>
 *     非严格递减, 入栈后的如果不弹栈, noop, 如果弹栈, 即可计算储水量了.
 * </pre>
 *
 *
 *
 * <a href="https://leetcode-cn.com/problems/trapping-rain-water/">接雨水</a>
 */
public class P42TrapOP {
}
