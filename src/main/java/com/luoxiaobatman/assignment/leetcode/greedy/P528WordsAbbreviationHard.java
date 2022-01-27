package com.luoxiaobatman.assignment.leetcode.greedy;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;

/**
 * 给你一个字符串数组 words ，该数组由 互不相同 的若干字符串组成，请你找出并返回每个单词的 最小缩写 。
 * <p>
 * 生成缩写的规则如下：
 * <p>
 * 初始缩写由起始字母+省略字母的数量+结尾字母组成。
 * 若存在冲突，亦即多于一个单词有同样的缩写，则使用更长的前缀代替首字母，直到从单词到缩写的映射唯一。换而言之，最终的缩写必须只能映射到一个单词。
 * 若缩写并不比原单词更短，则保留原样。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: words = ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
 * 输出: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
 * 示例 2：
 * <p>
 * 输入：words = ["aa","aaa"]
 * 输出：["aa","aaa"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 400
 * 2 <= words[i].length <= 400
 * words[i] 由小写英文字母组成
 * words 中的所有字符串 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-abbreviation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P528WordsAbbreviationHard extends AbstractSolution<int[]> implements GenericSolution<int[]> {
    /**
     * l
     * @return
     */
    @Override
    public int[] doSolve() {
        return new int[0];
    }
}
