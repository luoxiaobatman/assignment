package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

/**
 * 并查集
 */
@AllArgsConstructor
public class P261UP
        extends AbstractSolution<Boolean> implements GenericSolution<Boolean> {
    private final int n;
    private final int[][] edges;

    @Override
    public Boolean doSolve() {
        return validTree(n, edges);
    }

    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            if (uf.find(edge[0]) == uf.find(edge[1])) {
                return false;
            }
            uf.union(edge[0], edge[1]);
        }
        return uf.count() == 1;
    }

    private static class UF {
        private int[] parent, rank;

        public UF(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int t) {
            while (parent[t] != t) {
                parent[t] = parent[parent[t]];
                t = parent[t];
            }
            return t;
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return;
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else {
                parent[rootA] = rootB;
                rank[rootB]++;
            }
        }

        private int count() {
            int ans = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) ans++;
            }
            return ans;
        }
    }
}
