package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 单连通分量
 */
@AllArgsConstructor
public class P323
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int n;
    private final int[][] edges;

    @Override
    public Integer doSolve() {
        return countComponents(n, edges);
    }

    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        long count = IntStream.range(0, n).filter((i) -> {
            if (!visited.contains(i)) {
                Queue<Integer> waiting = new LinkedList<>();
                waiting.offer(i);
                Integer next;
                while ((next = waiting.poll()) != null) {
                    Set<Integer> adjacent = graph.get(next);
                    for (Integer nextNode : adjacent) {
                        if (!visited.contains(nextNode)) {
                            visited.add(nextNode);
                            waiting.offer(nextNode);
                        }
                    }
                }
                return true;
            }
            return false;
        }).count();

        return (int) count;
    }
}
