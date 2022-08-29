package com.luoxiaobatman.assignment.leetcode;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 *
 */
@AllArgsConstructor
public class LongestWordBrutalForce extends AbstractSolution<String> implements GenericSolution<String> {
    private final String[] words;

    @Override
    public String doSolve() {
        return longestWord(words);
    }

    public String longestWord (String[] words) {
        sortWords(words);
        boolean[] visited = new boolean[words.length];
        int foundedWordsSize = 0;
        for (int i = 0; i < words.length; i++) {
            String candidate = words[i];
            visited[i] = true;
            if(isCandidateComposedByWords(candidate, words, visited, foundedWordsSize)) {
                return candidate;
            }
            visited[i] = false;
        }
        return "";
    }

    /**
     * inplace排序, order by (length大, 字典序小)
     */
    private void sortWords(String[] words) {
        Arrays.sort(words, (a, b) -> {
            int al = a.length();
            int bl = b.length();
            if (al > bl) {
                return -1;
            } else if (bl > al) {
                return 1;
            } else {
                return a.compareTo(b);
            }
        });
    }

    /**
     * candidate 是否属于words的组合 (word不重复使用)
     * @param candidate 候选单词
     * @param words ...
     * @param visited 重复访问标记
     * @param foundedWordsSize 递归过程中已找到的单词数量
     * @return candidate是否是words中任序组合
     */
    private boolean isCandidateComposedByWords(String candidate,
                                               String[] words,
                                               boolean[] visited,
                                               int foundedWordsSize) {
        for (int i = 0; i < words.length; i++) {
            String prefix = words[i];
            if (!visited[i]) {
                if (candidate.startsWith(prefix)) {
                    int prefixLength = prefix.length();
                    visited[i] = true;
                    foundedWordsSize++;
                    if (candidate.length() == prefixLength) {
                        return foundedWordsSize > 1;
                    } else {
                        if (isCandidateComposedByWords(
                                candidate.substring(prefixLength),
                                words,
                                visited,
                                foundedWordsSize)) {
                            return true;
                        }
                    }
                    visited[i] = false;
                    foundedWordsSize--;
                }
            }
        }
        return false;
    }
}
