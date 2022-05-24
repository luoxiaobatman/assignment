package com.luoxiaobatman.assignment.interview.coding.huawei.spring2022;

import com.luoxiaobatman.assignment.interview.huawei.spring2022.ChessBoardSimpleGo;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardSimpleGoTest {
    /**
     * 0 0
     * 1 0
     *
     * 0 1 0
     * 0 0 0
     *
     * 0 0 0
     * 0 1 0
     * 0 0 0
     *
     * 1 0 0 1
     * 0 1 0 1
     * 0 0 0 0
     *
     * 1 0 0 1
     * 0 1 1 1
     * 0 0 0 0
     *
     */
    @ParameterizedTest
    @SolutionSource(value = {
//            "0|0,1|0", "1|0",
//            "0|1|0,0|0|0", "0|1",
//            "1|0|0|1,0|1|0|1,0|0|0|0", "0|0,1|1",
            "1|0|0|1,0|1|1|1,0|0|0|0", "0|0",
    })
    void doSolve(int[][] board, int[][] expected) {
        int[][] actual = Solver.solve(ChessBoardSimpleGo.class, (Object) board);
        assertArrayEquals(expected, actual);
    }
}