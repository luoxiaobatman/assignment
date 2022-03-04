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
public class P684UP
        extends AbstractSolution<int[]> implements GenericSolution<int[]> {
    private final int[][] edges;

    @Override
    public int[] doSolve() {
        return findRedundantConnection(edges);
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(1002);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }

    private static class UnionFind {
        private int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int n) {
            while (parent[n] != n) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }

        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return false;
            parent[rootA] = rootB;
            return true;
        }
    }
}
