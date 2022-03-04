package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 * 深度优先, 记忆
 */
@AllArgsConstructor
public class P329
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[][] matrix;

    @Override
    public Integer doSolve() {
        return longestIncreasingPath(matrix);
    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] mem = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            mem[i] = new int[matrix[0].length];
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph.put(i * 400 + j, new HashSet<>());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Set<Integer> adjacent = graph.get(i * 400 + j);
                int val = matrix[i][j];
                try {
                    if (val < matrix[i][j - 1]) {
                        adjacent.add(i * 400 + j - 1);
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
                try {
                    if (val < matrix[i][j + 1]) {
                        adjacent.add(i * 400 + j + 1);
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
                try {
                    if (val < matrix[i - 1][j]) {
                        adjacent.add(i * 400 - 400 + j);
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
                try {
                    if (val < matrix[i + 1][j]) {
                        adjacent.add(i * 400 + 400 + j);
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
            }
        }

        // dfs
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(graph, mem, i, j);
                max = Math.max(max, mem[i][j]);
            }
        }
        return max;
    }

    private void dfs(Map<Integer, Set<Integer>> graph, int[][] mem, int i, int j) {
        if (mem[i][j] > 0) return;
        mem[i][j] = doDFS(graph, mem, i, j);
    }

    private int doDFS(Map<Integer, Set<Integer>> graph, int[][] mem, int i, int j) {
        int n = 400;
        int idx = i * n + j;
        Set<Integer> adjacent = graph.get(idx);
        int nextMax = 0;
        for (Integer integer : adjacent) {
            int nextI = integer / n;
            int nextJ = integer % n;
            int nextHeight = mem[nextI][nextJ];
            if (nextHeight == 0) {
                nextHeight = doDFS(graph, mem, nextI, nextJ);
                mem[nextI][nextJ] = nextHeight;
            }
            nextMax = Math.max(nextMax, nextHeight);
        }
        return nextMax + 1;
    }
}
