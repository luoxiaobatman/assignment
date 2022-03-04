package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.datastructure.tree.UF;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 并集查
 */
@AllArgsConstructor
public class P323UP
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int n;
    private final int[][] edges;

    @Override
    public Integer doSolve() {
        return countComponents(n, edges);
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count();
    }

    private static class UnionFind {
        private final int[] parent;
        public UnionFind(int n) {
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

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                parent[rootA] = rootB;
            }
        }

        public int count() {
            int res = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) res++;
            }
            return res;
        }
    }
}
