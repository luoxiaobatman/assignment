package com.luoxiaobatman.assignment.interview.coding.huawei.spring2022;

import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinimumBreakTest {

    @ParameterizedTest
    @SolutionSource(value = {
            "1|2|2|1,3|1|2,1|3|2,2|4,3|1|2,1|3|1|1", "2"  // 一行一个用例
    })
    void doSolve(List breakss, Integer expected) {
        Integer actual = Solver.solve(MinimumBreak.class, breakss);
        assertEquals(expected, actual);
    }
}
