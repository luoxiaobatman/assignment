package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.IntArgumentsParser;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;

public class P787FindCheapestPriceMediumFATest {
    @ParameterizedTest
    @SolutionSource(value = {
            "3", "0.1.100,0.2.500,1.2.100", "0", "2", "2", "200"
    }, argumentsCount = 6, argumentsParsers = {
            IntArgumentsParser.class,
            P787FlightsArgumentsParser.class,
            IntArgumentsParser.class,
            IntArgumentsParser.class,
            IntArgumentsParser.class,
            IntArgumentsParser.class}, delimiter = ",")
    void test(int n, int[][] flights, int src, int dst, int k, int expected) {
        Integer actual = Solver.solve(P787FindCheapestPriceMediumFA.class, n, flights, src, dst, k);
        Assertions.assertEquals(expected, actual);

    }
}