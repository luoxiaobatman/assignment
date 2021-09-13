package com.luoxiaobatman.assignment.leetcode.foryou;

import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

public class P2134ImprovedTest {
    @Test
    void testP2134(TestReporter reporter) {
        Solution solution = Factory.of(Solution.class).newInstance(P2134Improved.class);
        P2134Improved.P2134ImprovedAnswer answer = (P2134Improved.P2134ImprovedAnswer)  solution.solve().getAnswer();
        Assertions.assertTrue(answer.insert(2));
        Assertions.assertTrue(answer.insert(3));
        Assertions.assertTrue(answer.insert(4));
        Assertions.assertTrue(answer.remove(4));
        Assertions.assertFalse(answer.remove(5));
        reporter.publishEntry(answer.getRandom().toString());
        reporter.publishEntry(answer.getRandom().toString());
        reporter.publishEntry(answer.getRandom().toString());
        reporter.publishEntry(answer.getRandom().toString());
    }
}
