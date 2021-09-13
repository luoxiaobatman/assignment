package com.luoxiaobatman.assignment.leetcode.foryou;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

public class P2134Test {
    @Test
    void testP2134(TestReporter reporter) {
        Solution solution = Factory.of(Solution.class).newInstance(P2134.class);
        Answer answer = solution.solve();
        P2134.P2134Answer p2134Answer = (P2134.P2134Answer) answer.getAnswer();
        Assertions.assertTrue(p2134Answer.insert(2));
        Assertions.assertTrue(p2134Answer.insert(3));
        Assertions.assertTrue(p2134Answer.insert(4));
        Assertions.assertTrue(p2134Answer.remove(4));
        Assertions.assertFalse(p2134Answer.remove(5));
        reporter.publishEntry(p2134Answer.getRandom().toString());
        reporter.publishEntry(p2134Answer.getRandom().toString());
        reporter.publishEntry(p2134Answer.getRandom().toString());
    }
}
