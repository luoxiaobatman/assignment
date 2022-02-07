package com.luoxiaobatman.assignment.leetcode.un;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

/**
 * 每个节点1个标记, 标记由两部分组成, 一部分为以该点作为`拐(顶)点`的路径的最大路径的值, 另一部分通过该节点的所有孩子的最大值
 * <p>
 * 算法采用广度度优先, 后序的方式, 后序的处理逻辑是: 左孩和右孩的标记, 以及自身的val, 更新自己的标记
 * <p>
 * 所有节点计算完毕, 即得到题目答案
 * <p>
 * 复杂度: 时间 O(n), 空间O(1)
 * <p>
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@AllArgsConstructor
public class P124MaxPathSumHardFA
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    @Override
    public Integer doSolve() {
        return null;
    }
}
