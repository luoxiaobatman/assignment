package com.luoxiaobatman.assignment.leetcode.milestone.easy;

import com.luoxiaobatman.assignment.leetcode.ListNode;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 *
 */
@AllArgsConstructor
public class P30
        extends AbstractSolution<int[]> implements GenericSolution<int[]> {
    private final String s;
    private final String[] words;

    @Override
    public int[] doSolve() {
        List<Integer> substring = findSubstring(s, words);
        int[] ret = new int[substring.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = substring.get(i);
        }
        return ret;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> el = Collections.emptyList();
        if (words.length == 0) return el;
        int windowSize = words[0].length();
        if (windowSize > s.length()) return el;
        int targetSize = words.length;
        List<Integer> ret = new ArrayList<>();
        Map<String, Integer> o = new HashMap<>();
        for (String word : words) {
            if (o.containsKey(word)) {
                o.put(word, o.get(word) + 1);
            } else {
                o.put(word, 1);
            }
        }
        Wrapper[] wrappers = new Wrapper[windowSize];
        for (int i = 0; i < windowSize; i++) {
            wrappers[i] = new Wrapper(o);
        }

        for (int i = 0; i < s.length() - windowSize + 1; i++) {
            String chunk = s.substring(i, i + windowSize);
            int hash = i % windowSize;
            if (!o.containsKey(chunk)) {
                if (wrappers[hash].taint) {
                    wrappers[hash] = new Wrapper(o);
                }
            } else {
                wrappers[hash].taint = true;
                Map<String, Integer> m = wrappers[hash].m;
                Queue<String> q = wrappers[hash].q;
                Integer left = m.get(chunk);
                if (left > 0) {
                    m.put(chunk, left - 1);
                    q.offer(chunk);
                    if (q.size() == targetSize) {
                        String poll = q.poll();
                        m.put(poll, m.get(poll) + 1);
                        ret.add(i - windowSize * (targetSize - 1));
                    }
                } else {
                    String poll;
                    while (!(poll = q.poll()).equals(chunk)) {
                        m.put(poll, m.get(poll) + 1);
                    }
                    q.offer(poll);
//                    m.put(chunk, m.get(chunk) + 1);
                }
            }
        }
        return ret;
    }

    private static class Wrapper {
        public Queue<String> q;
        public Map<String, Integer> m;
        public boolean taint = false;
        public Wrapper(Map<String, Integer> o) {
            m = new HashMap<>(o);
            q = new ArrayDeque<>();
        }
    }
}
