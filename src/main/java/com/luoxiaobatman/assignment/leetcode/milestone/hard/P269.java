package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 *
 */
@AllArgsConstructor
public class P269
        extends AbstractSolution<String> implements GenericSolution<String> {
    private final String[] words;

    @Override
    public String doSolve() {
        return alienOrder(words);
    }

    /**
     * @param words construct edges
     * @return ordered
     */
    public String alienOrder(String[] words) {
        if (words.length < 1) return "";
        // 入度
        HashMap<Integer, Character> mapping = new HashMap<>();
        HashMap<Character, Integer> reverseMapping = new HashMap<>();
        Set<Character> alphabets = new HashSet<>();
        int key = 0;
        HashMap<Integer, Integer> indegreeMap = new HashMap<>();
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                if (!alphabets.contains(c)) {
                    mapping.put(key, c);
                    reverseMapping.put(c, key);
                    alphabets.add(c);
                    key++;
                }
            }
            if (i != 0) {
                int[] edge;
                try {
                    edge = order(words[i - 1], words[i], reverseMapping);
                } catch (IllegalArgumentException ignored) {
                    return "";
                }
                if (edge != null) {
                    Integer degree = indegreeMap.getOrDefault(edge[1], 0);
                    indegreeMap.put(edge[1], degree + 1);
                    edges.add(edge);
                }
            }
        }

        int[] indegree = new int[key];
        for (int i = 0; i < indegree.length; i++) {
            indegree[i] = indegreeMap.getOrDefault(i, 0);
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> adjacent = graph.computeIfAbsent(edge[0], k -> new ArrayList<>());
            adjacent.add(edge[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        Integer next;
        while ((next = q.poll()) != null) {
            sb.append(mapping.get(next));
            List<Integer> adjacent = graph.get(next);
            graph.put(next, null);
            if (adjacent != null) {
                for (Integer node : adjacent) {
                    if (--indegree[node] == 0) {
                        q.offer(node);
                    }
                }
            }
        }
        for (int degree : indegree) {
            if (degree > 0) return "";
        }

        return sb.toString();
    }

    private int[] order(String prev, String next, HashMap<Character, Integer> reverseMapping) {
        int l = Math.max(prev.length(), next.length());
        for (int i = 0; i < l; i++) {
            try {
                int prevInt = reverseMapping.get(prev.charAt(i));
                int nextInt = reverseMapping.get(next.charAt(i));
                if (prevInt != nextInt) {
                    return new int[]{prevInt, nextInt};
                }
            } catch (IndexOutOfBoundsException ignored) {
                if (prev.length() > next.length()) {
                    throw new IllegalArgumentException();
                }
                return null;
            }
        }
        return null;
    }
}
