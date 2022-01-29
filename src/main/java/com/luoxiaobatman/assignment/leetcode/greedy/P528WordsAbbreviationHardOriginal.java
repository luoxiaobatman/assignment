package com.luoxiaobatman.assignment.leetcode.greedy;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * leetcode的题目描述让爷掉坑里, 做成了前缀 + 后缀的solution, 如下:
 * <p>
 * "like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"
 * <p>
 * "l2e","god","i4nal","me","i6t","i4val","inte4n","f2e","intr4n"
 * <p>
 * <p>
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
@AllArgsConstructor
public class P528WordsAbbreviationHardOriginal
        extends AbstractSolution<String[]> implements GenericSolution<String[]> {
    private String[] words;

    /**
     * @return
     */
    @Override
    public String[] doSolve() {
        return wordsAbbreviation(List.of(words)).toArray(String[]::new);

    }

    public List<String> wordsAbbreviation(List<String> words) {
        List<Holder> resultHolders = new ArrayList<>();
        String[] result = new String[words.size()];
        Map<String, List<Holder>> lengthHoldersMap = groupWords(words);
        for (List<Holder> holders : lengthHoldersMap.values()) {
            if (holders.size() == 1) {
                Holder holder = holders.get(0);
                holder.resolved = true;
                holder.resolvedAbb = holder.abb;
                resultHolders.addAll(holders);
            } else {
                resultHolders.addAll(resolveConflict(new HashSet<>(holders)));
            }
        }
        for (Holder holder : resultHolders) {
            result[words.indexOf(holder.source)] = holder.resolvedAbb;
        }
        return List.of(result);
    }

    /**
     * abbr length - 1
     */
    private Set<Holder> resolveConflict(Set<Holder> conflicts) {
        Holder peek = null;
        for (Holder holder : conflicts) {
            peek = holder;
            break;
        }
        assert peek != null;
        int abbrLength = peek.frontSize + peek.endSize + 1;
        Set<Holder> result = new HashSet<>();
        for (int i = 1; i < abbrLength; i++) {
            for (Holder holder : conflicts) {
                holder.frontSize = i;
                holder.endSize = abbrLength - i;
                holder.buildAbbr();
            }
            for (List<Holder> holders : group(conflicts).values()) {
                if (holders.size() == 1) {
                    Holder holder = holders.get(0);
                    if (holder.conflict && !holder.resolved) {
                        holder.conflict = false;
                        holder.resolved = true;
                        holder.resolvedAbb = holder.abb;
                        result.add(holder);
                    }
//                    conflicts.removeAll(holders);
                } else {
                    for (Holder holder : holders) {
                        if (!holder.resolved) {
                            holder.conflict = true;
                        }
                    }
                }
            }
        }
        if (peek.source.length() - abbrLength > 1) {
            result.addAll(resolveConflict(conflicts));
        }
        return result;
    }

    private Map<String, List<Holder>> groupWords(List<String> words) {
        return words.stream()
                .map(Holder::new)
                .collect(Collectors.groupingBy(holder -> holder.abb));
    }

    private Map<String, List<Holder>> group(Set<Holder> holders) {
        return holders.stream()
                .collect(Collectors.groupingBy(holder -> holder.abb));
    }

    private static final class Holder {
        Holder(String s) {
            source = s;
            frontSize = 1;
            endSize = 1;
            buildAbbr();
        }

        public void buildAbbr() {
            if (source.length() - frontSize - endSize < 2) {
                abb = source;
            } else {
                this.abb = String.format("%s%d%s",
                        source.substring(0, frontSize),
                        source.length() - frontSize - endSize,
                        source.substring(source.length() - endSize));
            }
        }

        String source;
        /**
         * f8s
         */
        String abb;
        /**
         * 0 means no abbrev
         */
        private int frontSize = 0;
        private int endSize = 0;
        private boolean resolved = false;
        private boolean conflict = true;
        private String resolvedAbb;
    }
}
