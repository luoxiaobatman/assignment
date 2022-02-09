package com.luoxiaobatman.assignment.leetcode.un;

import com.luoxiaobatman.assignment.support.IntArgumentsParser;
import com.luoxiaobatman.assignment.support.IntsArgumentsParser;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class NC41MaxLengthMediumFATest {

    @ParameterizedTest
    @SolutionSource(value = {
        "2,2,3,4,3", "3",
        "1,2,3,1,2,3,2,2", "3",
        "2,2,3,4,8,99,3", "5",
        "2,3,4,5", "4",
    }, argumentsParsers = {
            IntsArgumentsParser.class,
            IntArgumentsParser.class,
    }, delimiter = ",", argumentsCount = 2)
    void doSolve(int[] arr, int expected) {
        Integer actual = Solver.solve(NC41MaxLengthMediumFA.class, (Object) arr);
        assertEquals(expected, actual);
    }
}