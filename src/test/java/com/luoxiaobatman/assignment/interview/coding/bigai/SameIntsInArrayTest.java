package com.luoxiaobatman.assignment.interview.coding.bigai;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class SameIntsInArrayTest {

    @ParameterizedTest
    @SolutionSource(value = {
            "1,2,3", "1,2,3", "1,2,3",
            "1,2,2,3", "1,2,3", "1,2,3",
    })
    void doSolve(int[] a, int[] b, int[] expected) {
        int[] actual = Solver.solve(SameIntsInArray.class, a, b);
        assertArrayEquals(expected, actual);
    }
}
