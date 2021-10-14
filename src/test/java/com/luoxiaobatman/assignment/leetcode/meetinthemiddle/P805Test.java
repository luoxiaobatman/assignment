package com.luoxiaobatman.assignment.leetcode.meetinthemiddle;

import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

/**
 * TODO 参数类型转换
 */
public class P805Test {
    @CsvSource(value = {
            "1,2,3,4,5,6,7,8 true",
            "2,3 false",
            "7,3,4 false",
    }, delimiter = ' ')
    @ParameterizedTest
    void testP805(String sourceString, String expectedString) {
        String[] strings = Arrays.stream(sourceString.split(",")).toArray(String[]::new);
        int[] source = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            source[i] = Integer.parseInt(strings[i]);
        }
        boolean expected = Boolean.parseBoolean(expectedString);
        Solution solution = Factory.of(Solution.class).newInstance(P805.class, source);
        Object answer = solution.solve().getAnswer();
        Assertions.assertEquals(expected, answer);
    }
}
