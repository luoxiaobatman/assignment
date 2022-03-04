package com.luoxiaobatman.assignment.leetcode.greedy;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P630UPTest {

    @ParameterizedTest
    @SolutionSource(value = {
//            "100|200,200|1300,1000|1250,2000|3200", "3",
            "5|15,3|19,6|7,2|10,5|16,8|14,10|11,2|19", "5",
    })
    void doSolve(int[][] course, Integer expected) {
        Integer actual = Solver.solve(P630UP.class, (Object) course);
        assertEquals(expected, actual);
    }
}