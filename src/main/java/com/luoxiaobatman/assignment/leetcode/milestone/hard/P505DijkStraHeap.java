package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class P505DijkStraHeap
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[][] maze;
    private final int[] start;
    private final int[] dst;

    @Override
    public Integer doSolve() {
        return shortestDistance(maze, start, dst);
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        return dijkstra(maze, start, destination);
    }

    private int dijkstra(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        q.offer(new int[]{start[0], start[1], 0});
        int N = 200;
        Map<Integer, Set<int[]>> graph = new HashMap<>();
        Map<Integer, Integer> shortestMap = new HashMap<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                shortestMap.put(i * N + j, Integer.MAX_VALUE);
            }
        }
//        shortest.put(start[0] * N + start[1], 0);
        int[] point;
        while ((point = q.poll()) != null) {
            int idx = point[0] * N + point[1];
            int shortest = shortestMap.get(idx);
            if (point[2] <= shortest) {
                shortest = point[2];
                Set<int[]> adjacent = graph.get(idx);
                if (adjacent == null) {
                    adjacent = getAdjacent(maze, graph, point[0], point[1]);
                }
                for (int[] adjacentPoint : adjacent) {
                    int adjacentPointIdx = adjacentPoint[0] * N + adjacentPoint[1];
                    if (shortestMap.get(adjacentPointIdx) > shortest + adjacentPoint[2]) {
                        shortestMap.put(adjacentPointIdx, shortest + adjacentPoint[2]);
                        q.offer(new int[]{adjacentPoint[0], adjacentPoint[1], shortest + adjacentPoint[2]});
                    }
                }
            }
        }
        int shortest = shortestMap.get(destination[0] * N + destination[1]);
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    private Set<int[]> getAdjacent(int[][] maze, Map<Integer, Set<int[]>> graph, int i, int j) {
        int idx = i * 200 + j;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Set<int[]> adjacent = new HashSet<>();
        graph.put(idx, adjacent);
        for (int[] direction : directions) {
            int[] point = {i, j, 0};
            try {
                while (maze[point[0] + direction[0]][point[1] + direction[1]] != 1) {
                    point[0] += direction[0];
                    point[1] += direction[1];
                    point[2]++;
                }
            } catch (IndexOutOfBoundsException ignored) { }
            if (point[2] != 0) {
                adjacent.add(point);
            }
        }
        return adjacent;
    }
}
