package com.luoxiaobatman.assignment.leetcode.greedy;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.StringsArgumentsParser;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P528WordsAbbreviationHardTrieTest {
    @ParameterizedTest
    @SolutionSource(value = {
//            "ffds,ssaf","f2s,s2f",
//            "ffds,fsas","ffds,fsas",
//            "intension,intrusion", "inte4n,intr4n",
//            "internal,internet,interval", "internal,i6t,interval",
//            "internet", "i6t",
            "like,god,internal,me,internet,interval,intension,face,intrusion",
            "l2e,god,internal,me,i6t,interval,inte4n,f2e,intr4n",
            "meet,met", "m2t,met"
    }, argumentsCount = 2, argumentParser = StringsArgumentsParser.class, delimiter = ",")
    void test(String[] words, String[] expected) {
        String[] solve = Solver.solve(P528WordsAbbreviationHardTrie.class, (Object) words);
        assertArrayEquals(expected, solve);
    }
}
