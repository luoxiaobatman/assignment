package com.luoxiaobatman.assignment.leetcode.un;


import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

/**
 * 滑动窗口
 * <p>
 * 字符数组a, 添加标记flag:boolean类型
 * <pre>
 * 初始化队列q, 遍历a, 队列q的头是a中在p的第一个字符对象, 直到覆盖完p, 记录队列的toString
 * 继续遍历a往下走, 每遇到p中的相同字符串, 就在队列q中找到第一个flag为false的该字符对象, 将flag变为true, 如果该对象为
 * q的头, 对q就行出队列操作直到对象的flag为false, 比较l并记录队列最小长度的toString.
 * 直到a遍历完成
 * </pre>
 * 时间复杂度 O(n)
 * 空间复杂度 O(m)
 * <p>
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 *  
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *  
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@AllArgsConstructor
public class P76MinWindowHardFA
        extends AbstractSolution<String> implements GenericSolution<String> {
    @Override
    public String doSolve() {
        return null;
    }
}
