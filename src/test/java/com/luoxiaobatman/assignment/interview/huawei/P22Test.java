package com.luoxiaobatman.assignment.interview.huawei;

import com.luoxiaobatman.assignment.interview.coding.huawei.P22;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P22Test {

    @ParameterizedTest
    @SolutionSource(value = {
            "2", "()(),(())",
            "3", "()()(),(())(),()(()),((())),...",
    })
    void doSolve(Integer n, List<String> expected) {
        List<String> solution = Solver.solve(P22.class, n);
        for (String parenthesis : expected) {
            assertTrue(solution.contains(parenthesis));
        }
        for (String parenthesis : solution) {
            assertTrue(expected.contains(parenthesis));
        }
    }
}
