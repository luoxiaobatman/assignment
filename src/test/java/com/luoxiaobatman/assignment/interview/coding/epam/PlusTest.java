package com.luoxiaobatman.assignment.interview.coding.epam;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class PlusTest {
    @ParameterizedTest
    @SolutionSource(value = {
            "132", "990", "1122",
            "0", "55", "55",
            "", "55", "55",
            "", "", "",
            "f", "321", "NULL",
    })
    void doSolve(String rawNumber1, String rawNumber2, String expected) {
        String actual = Solver.solve(Plus.class, rawNumber1, rawNumber2);
        assertEquals(expected, actual);
    }
}