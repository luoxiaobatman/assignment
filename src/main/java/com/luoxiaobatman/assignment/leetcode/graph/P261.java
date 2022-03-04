package com.luoxiaobatman.assignment.leetcode.graph;

import com.google.common.collect.Lists;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class P261
        extends AbstractSolution<Boolean> implements GenericSolution<Boolean> {
    private final int n;
    private final int[][] edges;

    @Override
    public Boolean doSolve() {
        return validTree(n, edges);
    }

    public boolean validTree(int n, int[][] edges) {
        // 入度 判断是否有环
        if (edges.length == 0) {
            return n == 1;
        };
        int root = edges[0][0];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> adjacent = graph.computeIfAbsent(edge[0], k -> new HashSet<>());
            adjacent.add(edge[1]);

            adjacent = graph.computeIfAbsent(edge[1], k -> new HashSet<>());
            adjacent.add(edge[0]);
        }
        List<List<Integer>> loops = new ArrayList<>();
        List<Integer> chains = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        try {
            bfs(graph, chains, root, loops, visited);
        } catch (Loop loop) {
            return false;
        }
//        if (!loops.isEmpty()) return false;
        return visited.size() == n;
    }

    private void bfs(Map<Integer, Set<Integer>> graph, List<Integer> chains, int node, List<List<Integer>> loops,
                     Set<Integer> visited) throws Loop {
        Set<Integer> adjacent = graph.get(node);
        chains.add(node);
        visited.add(node);
        for (Integer adjacentNode : adjacent) {
            if (chains.contains(adjacentNode)) {
                throw new Loop();
                // 找环算法
//                loops.add(new ArrayList<>(chains));
            } else {
                // 无向图, 删除一条有向的边
                graph.get(adjacentNode).remove(node);
                bfs(graph, chains, adjacentNode, loops, visited);
            }
        }
        chains.remove((Integer) node);
    }

    private static class Loop extends Exception {}
}
