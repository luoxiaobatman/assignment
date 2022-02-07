package com.luoxiaobatman.assignment.leetcode.un;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

/**
 * 堆排, 找第K个最大
 * <p>
 * 时间: O(n) (生成最大堆) + 找到第K个 k*log(n)
 * 空间 O(n) 维护堆结构
 * <p>
 * 快排
 * 选择pivot, 找比它大的, 如果数量=k-1 返回, 如果数量小于k-1或者大于k-1, 选择一边或者另一边作为新数组, 改变k值 继续...
 * 直到找到pivot
 *
 * <a href="https://leetcode-cn.com/problems/kth-largest-element-in-an-array/">Q</a>
 */
@AllArgsConstructor
public class P215FindKthLargestMediumOO
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    @Override
    public Integer doSolve() {
        return null;
    }
}
