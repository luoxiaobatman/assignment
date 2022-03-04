package com.luoxiaobatman.assignment.interview.coding.bigai;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class SwitchIntegerTest {

    @ParameterizedTest
    @SolutionSource(value = {
//        "1,2", "2,1",
        "42423,2222", "2222,42423",
    })
    void doSolve(int[] sources, int[] expected) {
        int[] actual = Solver.solve(SwitchInteger.class, sources);
        assertArrayEquals(expected, actual);
    }
}
