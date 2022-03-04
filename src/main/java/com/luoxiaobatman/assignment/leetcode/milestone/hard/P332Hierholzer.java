package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 *
 */
@AllArgsConstructor
public class P332Hierholzer
        extends AbstractSolution<List<String>> implements GenericSolution<List<String>> {
    private final List<List<String>> tickets;

    @Override
    public List<String> doSolve() {
        return findItinerary(tickets);
    }

    private Deque<String> stack;
    public List<String> findItinerary(List<List<String>> tickets) {
        stack = new LinkedList<>();
        Map<String, Queue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!graph.containsKey(ticket.get(0))) {
                graph.put(ticket.get(0), new PriorityQueue<>());
            }
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }
        List<String> res = new ArrayList<>();
        dfs("JFK", graph);
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    private void dfs(String start, Map<String, Queue<String>> graph) {
        Queue<String> adjacent = graph.get(start);
        while (adjacent != null && !adjacent.isEmpty()) {
            String next = adjacent.poll();
            dfs(next, graph);
        }
        stack.push(start);
    }
}
