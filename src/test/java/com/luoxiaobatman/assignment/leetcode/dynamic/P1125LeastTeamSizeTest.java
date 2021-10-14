package com.luoxiaobatman.assignment.leetcode.dynamic;

import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class P1125LeastTeamSizeTest {
    private static class MyParameterProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Arrays.stream(new Arguments[] {
                Arguments.of(new String[] {"1", "2", "3"},  new String[][] {{"2"}, {"1", "3"}, {"1"}},  new int[] {0, 1}),
                Arguments.of(new String[] {"1", "2"},  new String[][] {{"2"}, {"1", "2"}},  new int[] {1}),
                Arguments.of(
                        new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "20", "21", "22", "23"},
                        new String[][] {
                                {"1", "2", "3", "4", "5", "6", "7"},
                                {"1", "2", "3", "4", "5", "6"},
                                {"1", "2", "6", "7"},
                                { "6"},
                                {"8"},
                                {"20", "21"},
                                {"22", "23"},
                                {"20", "21", "22", "23"},
                        },
                        new int[] {0, 4, 7}
                ),
            });
        }
    }

    @ArgumentsSource(MyParameterProvider.class)
    @ParameterizedTest(name = ParameterizedTest.INDEX_PLACEHOLDER)
    void test(String[] requiredSkills, String[][] people, int[] expected) {
        Solution solution = Factory.of(Solution.class).newInstance(P1125LeastTeamSize.class, requiredSkills, people);
        int[] answer = (int[]) solution.solve().getAnswer();
        Assertions.assertArrayEquals(expected, answer);
    }
}
