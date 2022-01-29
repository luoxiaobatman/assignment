package com.luoxiaobatman.assignment.leetcode.greedy;

import com.luoxiaobatman.assignment.datastructure.tree.NodeABC;
import com.luoxiaobatman.assignment.datastructure.tree.TrieABC;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 前缀树
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
public class P528WordsAbbreviationHardTrie
        extends AbstractSolution<String[]> implements GenericSolution<String[]> {
    private String[] words;

    @Override
    public String[] doSolve() {
        return wordsAbbreviation(List.of(words)).toArray(String[]::new);
    }

    public List<String> wordsAbbreviation(List<String> words) {
        Map<Integer, List<String>> sameLengthWordsMap = words.stream().collect(Collectors.groupingBy(String::length));
        Map<String, AbbreviationHolder> abbreviationMap = new HashMap<>();
        for (List<String> sameLengthWords : sameLengthWordsMap.values()) {
            abbreviationMap.putAll(wordsAbbreviationSameLength(sameLengthWords));
        }
        return words.stream().map(word -> abbreviationMap.get(word).wordAbbrev).collect(Collectors.toList());
    }

    public Map<String, AbbreviationHolder> wordsAbbreviationSameLength(List<String> words) {
        Map<Character, List<String>> suffixGroupedWords = words.stream().collect(
                Collectors.groupingBy(word -> word.charAt(word.length() - 1)));
        TrieABC[] tries = new TrieABC[26];
        for (Map.Entry<Character, List<String>> suffixWords : suffixGroupedWords.entrySet()) {
            int suffixIndex = suffixWords.getKey() - 'a';
            TrieABC wordSuffixTrie = new TrieABC();
            tries[suffixIndex] = wordSuffixTrie;
            for (String sameSuffixedWord : suffixWords.getValue()) {
                wordSuffixTrie.add(sameSuffixedWord);
            }
        }
        Map<String, AbbreviationHolder> abbreviationMap = new HashMap<>();
        for (TrieABC trie : tries) {
            if (trie == null) continue;
            List<AbbreviationHolder> abbreviationHolders = subprocess(trie);
            for (AbbreviationHolder abbreviationHolder : abbreviationHolders) {
                abbreviationHolder.word = abbreviationHolder.wordNode.word();
                abbreviationMap.put(abbreviationHolder.word, abbreviationHolder);
                if (abbreviationHolder.abbrev < 2) {
                    abbreviationHolder.wordAbbrev = abbreviationHolder.word;
                } else {
                    NodeABC fragmentNode = abbreviationHolder.wordNode;
                    for (int abbrev = abbreviationHolder.abbrev; abbrev > 0; abbrev--) {
                        fragmentNode = fragmentNode.getParent();
                    }
                    abbreviationHolder.wordAbbrev =
                            fragmentNode.prefix() + abbreviationHolder.abbrev + abbreviationHolder.wordNode.getCharacter();
                }
            }
        }
        return abbreviationMap;
    }

    private List<AbbreviationHolder> subprocess(TrieABC trie) {
        Set<NodeABC> allWordNodes = trie.getWholeWordNodes();
        List<AbbreviationHolder> abbreviations = new ArrayList<>();
        s: for (NodeABC wordNode : allWordNodes) {
            List<NodeABC> ancestors = new ArrayList<>();
            NodeABC ancestor = wordNode;
            while (!TrieABC.isRoot(ancestor)) {
                ancestors.add(0, ancestor);
                ancestor = ancestor.getParent();
            }
            for (int i = 0; i < ancestors.size(); i++) {
                if (ancestors.get(i).getFragmentWordCount() == 1) {
                    int abbrev = ancestors.size() - i - 2;
                    abbreviations.add(new AbbreviationHolder(wordNode, abbrev));
                    continue s;
                }
            }
            abbreviations.add(new AbbreviationHolder(wordNode, 0));
        }
        return abbreviations;
    }

    private static class AbbreviationHolder {
        private NodeABC wordNode;
        private int abbrev;
        private String word;
        private String wordAbbrev;

        public AbbreviationHolder(NodeABC wordNode, int abbrev) {
            this.wordNode = wordNode;
            this.abbrev = abbrev;
        }
    }
}
