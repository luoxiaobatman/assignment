package com.luoxiaobatman.assignment.leetcode.foryou;

import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.Arrays;
import java.util.List;

public class P841Test {
    @Test
    void testP841(TestReporter reporter) {
        List<Integer> room0 = Arrays.asList(0, 1, 3);
        List<Integer> room1 = Arrays.asList(0);
        List<Integer> room2 = Arrays.asList(3);
        List<Integer> room3 = Arrays.asList(2);
        List<List<Integer>> rooms = Arrays.asList(room0, room1, room2, room3);

        Solution solution = Factory.of(Solution.class).newInstance(P841.class, rooms);
        Object answer = solution.solve().getAnswer();
        reporter.publishEntry(answer.toString());
    }
}
