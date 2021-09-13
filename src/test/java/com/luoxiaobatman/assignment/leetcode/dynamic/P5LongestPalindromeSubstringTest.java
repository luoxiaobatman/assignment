package com.luoxiaobatman.assignment.leetcode.dynamic;

import com.luoxiaobatman.assignment.leetcode.provider.PalindromeProvider;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class P5LongestPalindromeSubstringTest {
    @ParameterizedTest(name = ParameterizedTest.INDEX_PLACEHOLDER)
    @ArgumentsSource(PalindromeProvider.class)
    public void test(String source, String expected) {
        Solution solution = Factory.of(Solution.class).newInstance(P5LongestPalindromeSubstring.class, source);
        Object answer = solution.solve().getAnswer();
        Assertions.assertEquals(expected, answer);
    }
}
