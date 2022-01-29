package com.luoxiaobatman.assignment.leetcode.greedy;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.StringsArgumentsParser;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P528WordsAbbreviationHardOriginalTest {
    @ParameterizedTest
    @SolutionSource(value = {
            "ffds,ssaf","f2s,s2f",
            "ffds,fsas","ffds,fsas",
            "intension,intrusion", "inte4n,intr4n",
            "internal,internet,interval", "i4nal,i6t,i4val",
            "like,god,internal,me,internet,interval,intension,face,intrusion",
            "l2e,god,i4nal,me,i6t,i4val,inte4n,f2e,intr4n",
    }, argumentsCount = 2, argumentParser = StringsArgumentsParser.class, delimiter = ",")
    void test(String[] words, String[] expected) {
        String[] solve = Solver.solve(P528WordsAbbreviationHardOriginal.class, (Object) words);
        assertArrayEquals(expected, solve);
    }
}
