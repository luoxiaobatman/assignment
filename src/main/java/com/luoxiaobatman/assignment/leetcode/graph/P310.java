package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 * 并查集
 */
@AllArgsConstructor
public class P310
        extends AbstractSolution<int[]> implements GenericSolution<int[]> {
    private final int n;
    private final int[][] edges;

    @Override
    public int[] doSolve() {
        List<Integer> minHeightTrees = findMinHeightTrees(n, edges);
        int[] res = new int[minHeightTrees.size()];
        for (int i = 0; i < minHeightTrees.size(); i++) {
            res[i] = minHeightTrees.get(i);
        }
        return res;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        int[] degrees = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        // bfs
        Integer node = 0;
        for (; node < degrees.length; node++) {
            if (degrees[node] == 1) {
                q.offer(node);
            }
        }

        List<Integer> res = new ArrayList<>();

        while ((node = q.poll()) != null) {
            res.clear();
            List<Integer> adjacent = graph.get(node);
            res.add(node);
            while ((node = q.poll()) != null) {
                res.add(node);
                adjacent.addAll(graph.get(node));
            }
            for (Integer adjacentNode : adjacent) {
                degrees[adjacentNode]--;
                if (degrees[adjacentNode] == 1) {
                    q.offer(adjacentNode);
                }
            }
        }
        return res;
    }
}
