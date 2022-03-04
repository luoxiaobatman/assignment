package com.luoxiaobatman.assignment.leetcode.greedy;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class P630
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[][] courses;

    @Override
    public Integer doSolve() {
        return scheduleCourse(courses);
    }

    public int scheduleCourse(int[][] courses) {
        // 贪心的猜测
        Arrays.sort(courses, (c1, c2) -> {
            if (c1[0] != c2[0]) return c1[0] - c2[0];
            return c1[1] - c2[1];
        });
        List<Integer> scheduled = new ArrayList<>();
        // scheduled里面的时间总和
        int timeSpent = 0;
        for (int i = 0; i < courses.length; i++) {
            int[] course = courses[i];
            int endTime = course[1];
            int courseTimeSpent = course[0];
            if (courseTimeSpent > endTime) continue;

            int j = scheduled.size();
            // 0 - j 的scheduled里面的时间总和
            int tmpTimeSpent = timeSpent;
            while (j > -1) {
                // course是否能够放在 j 前
                if (tmpTimeSpent + course[0] <= course[1]) {
                    // 能, 贪心找到最合适的位置
                    while (j > 0 && courses[scheduled.get(j - 1)][1] > endTime) {
                        j--;
                    }
                    scheduled.add(j, i);
                    timeSpent += courseTimeSpent;
                    break;
                }
//                tmpTimeSpent -= courses[scheduled.get(j)][1];
                j--;
                if (j >= 0) {
                    int[] prevCourse = courses[scheduled.get(j)];
                    if (courseTimeSpent + tmpTimeSpent > prevCourse[1]) {
                        break;
                    }
                    tmpTimeSpent -= prevCourse[0];
                }
            }
        }
        return scheduled.size();
    }
}
