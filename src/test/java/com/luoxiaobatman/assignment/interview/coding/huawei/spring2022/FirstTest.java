package com.luoxiaobatman.assignment.interview.coding.huawei.spring2022;

import com.luoxiaobatman.assignment.support.IntArgumentsParser;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class FirstTest {

    @ParameterizedTest
    @SolutionSource(value = {
        "1", "1"
    }, argumentsCount = 2, argumentsParsers = {
            IntArgumentsParser.class,
            IntArgumentsParser.class
    })
    void doSolve(int arg, int expected) {
        Integer solve = Solver.solve(WorkerWorks.class, arg);
        assertEquals(solve, expected);

    }
}