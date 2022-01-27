package com.luoxiaobatman.assignment.leetcode.greedy;

import com.luoxiaobatman.assignment.support.IntsArgumentsParser;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P321HardTest {
    @ParameterizedTest
    @SolutionSource(value = {
            "3465", "912583", "98653",
            "67", "604", "67604",
            "39", "89", "989",
            "01", "065762", "06576201",
            "0070227355", "054553334", "0545533340070227355",
            "469106315283884720719901593939730810916884457528277748509692", "4512093463092882486544295073759668802422166536296459780723", "9999999999988688445752827774850969202422166536296459780723",
            "217801735890070227355", "26201054553334", "26221780173589010545533340070227355",
    }, argumentsCount = 3, argumentParser = IntsArgumentsParser.class)
    void test(int[] num1, int[] num2, int[] expected) {
        int[] solve = Solver.solve(P321HardFaster.class, num1, num2, expected.length);
        assertArrayEquals(expected, solve);
    }
}
