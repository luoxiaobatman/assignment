package com.luoxiaobatman.assignment.datastructure.string;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KMPTest {
    @ParameterizedTest
    @SolutionSource(value = {
        "argumentscount", "solutionsourceparamargumentscounteterizedtest", "true",
        "argumentscount", "solutionsourceparargumetscounteterizedtest", "false"
    }, argumentsCount = 3)
    void doSolve(String pattern, String text, String rawExpected) {
        boolean expected = Boolean.parseBoolean(rawExpected);
        Boolean actual = Solver.solve(KMP.class, pattern, text);
        assertEquals(expected, actual);
    }
}
