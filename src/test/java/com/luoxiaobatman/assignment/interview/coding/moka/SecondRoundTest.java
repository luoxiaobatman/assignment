package com.luoxiaobatman.assignment.interview.coding.moka;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class SecondRoundTest {

    @ParameterizedTest
    @SolutionSource(value = {
            "1", "1"
    })
    void doSolve(Integer arg, Integer expected) {
        Integer actual = Solver.solve(SecondRound.class, arg);
        assertEquals(expected, actual);
    }
}