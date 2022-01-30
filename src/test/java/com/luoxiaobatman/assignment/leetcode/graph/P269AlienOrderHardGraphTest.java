package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.OrderedPair;
import com.luoxiaobatman.assignment.support.NoopArgumentsParser;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.StringsArgumentsParser;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P269AlienOrderHardGraphTest {

    @ParameterizedTest
    @SolutionSource(value = {
//            "wrt,wrf,er,ett,rftt", "wertf",
//            "z,x,z", "",
//            "z,z", "z",
            "abc,ab", ""
    }, argumentsCount = 2, argumentsParsers = {StringsArgumentsParser.class, NoopArgumentsParser.class}, delimiter = ",")
    void test(String[] alienWords, String expected) {
        String solve = Solver.solve(P269AlienOrderHardGraph.class, (Object) alienWords);
        assertEquals(expected, solve);
    }
}
