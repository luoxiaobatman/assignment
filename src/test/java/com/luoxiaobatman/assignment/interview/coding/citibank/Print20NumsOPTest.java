package com.luoxiaobatman.assignment.interview.coding.citibank;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class Print20NumsOPTest {

    @ParameterizedTest
    @SolutionSource(value = {
            "60", "0,1,2,3,4,5"
    })
    void doSolve(Integer l, int[] expected) {
        int[] actual = Solver.solve(Print20NumsOP.class, l);
        assertArrayEquals(expected, actual);
    }
}