package com.luoxiaobatman.assignment.leetcode.greedy;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 * 提升
 */
@AllArgsConstructor
public class P630UP
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[][] courses;

    @Override
    public Integer doSolve() {
        return scheduleCourse(courses);
    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        // 总的花费时间
        int total = 0;
        for (int[] course : courses) {
            int ti = course[0];
            int di = course[1];
            if (total + ti <= di) {
                total += ti;
                q.offer(ti);
            } else if (!q.isEmpty() && q.peek() > ti) {
                total = total - q.poll() + ti;
                q.offer(ti);
            }
        }
        return q.size();
    }
}
