package com.luoxiaobatman.assignment.leetcode.dynamic;

import com.luoxiaobatman.assignment.support.IntArgumentsParser;
import com.luoxiaobatman.assignment.support.IntsArgumentsParser;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P410SplitArrayHardDPTest {

    @ParameterizedTest
    @SolutionSource(value = {
            "7,2,5,10,8", "2", "18",
            "1,2,3,4,5", "2", "9",
            "1,4,4", "3", "4"
    }, argumentsCount = 3, argumentsParsers = {
            IntsArgumentsParser.class,
            IntArgumentsParser.class,
            IntArgumentsParser.class}, delimiter = ",")
    void doSolve(int[] arr, int k, int expected) {
        Integer solve = Solver.solve(P410SplitArrayHardDP.class, arr, k);
        assertEquals(expected, solve);
    }
}