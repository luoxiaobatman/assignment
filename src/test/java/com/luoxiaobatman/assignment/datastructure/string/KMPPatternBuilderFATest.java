package com.luoxiaobatman.assignment.datastructure.string;

import com.luoxiaobatman.assignment.support.IntsArgumentsParser;
import com.luoxiaobatman.assignment.support.NoopArgumentsParser;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class KMPPatternBuilderFATest {

    @ParameterizedTest
    @SolutionSource(value = {
        "aba\00", "-1,0,0,1",
        "abababababcab\00", "-1,0,0,1,2,3,4,5,6,7,8,0,1,2",
        "ababcadabd\00", "-1,0,0,1,2,0,1,0,1,2,0",
    }, argumentsCount = 2, argumentsParsers = {
            NoopArgumentsParser.class,
            IntsArgumentsParser.class
    }, delimiter = ",")
    void doSolve(String pattern, int[] expected) {
        int[] actual = Solver.solve(KMPPatternBuilderFA.class, pattern);
        assertArrayEquals(expected, actual);
    }
}
