package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 * in degree 入度表解法
 */
@AllArgsConstructor
public class P210
        extends AbstractSolution<int[]> implements GenericSolution<int[]> {
    private final int num;
    private final int[][] prerequisites;

    @Override
    public int[] doSolve() {
        return findOrder(num, prerequisites);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        // 邻接表 的hash变种
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            Set<Integer> adjacent = graph.get(prerequisite[1]);
            if (adjacent == null) {
                adjacent = new HashSet<>();
                graph.put(prerequisite[1], adjacent);
            }
            adjacent.add(prerequisite[0]);
        }

        Queue<Integer> waiting = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                waiting.offer(i);
            }
        }
        Integer next;
        int[] result = new int[numCourses];
        int i = 0;
        while ((next = waiting.poll()) != null) {
            result[i] = next;
            i++;
            Set<Integer> adjacent = graph.get(next);
            if (adjacent != null) {
                Set<Integer> remove = new HashSet<>();
                for (Integer current : adjacent) {
                    indegree[current]--;
                    if (indegree[current] == 0) {
                        waiting.offer(current);
                        remove.add(current);
                    }
                }
                adjacent.removeAll(remove);
            }
        }
        if (i != numCourses) {
            return new int[0];
        }
        return result;
    }
}
