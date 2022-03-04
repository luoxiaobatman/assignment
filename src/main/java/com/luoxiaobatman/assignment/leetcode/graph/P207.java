package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class P207
        extends AbstractSolution<Boolean> implements GenericSolution<Boolean> {
    private final int num;
    private final int[][] prerequisites;

    @Override
    public Boolean doSolve() {
        return canFinish(num, prerequisites);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new int[numCourses];
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]] = 1;
        }

        Set<Integer> chains = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int course = 0; course < numCourses; course++) {
            try {
                dfs(chains, visited, graph, course);
            } catch (Loop loop) {
                return false;
            }
        }
        return true;
    }

    private void dfs(Set<Integer> chains, Set<Integer> visited, int[][] graph, int course) throws Loop {
        chains.add(course);
        int[] dependencies = graph[course];
        for (int dependency = 0; dependency < dependencies.length; dependency++) {
            if (dependencies[dependency] == 1) {
                if (chains.contains(dependency)) {
                    throw new Loop();
                } else {
                    if (!visited.contains(dependency)) {
                        dfs(chains, visited, graph, dependency);
                    }
                }
            }
        }
        visited.add(course);
        chains.remove(course);
    }

    private static class Loop extends Exception {}
}
