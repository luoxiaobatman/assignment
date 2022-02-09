package com.luoxiaobatman.assignment.interview.coding.moka;

import com.luoxiaobatman.assignment.support.IntArgumentsParser;
import com.luoxiaobatman.assignment.support.IntsArgumentsParser;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.StringsArgumentsParser;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class LatestCommonDepTest {

    @ParameterizedTest
    @SolutionSource(value = {
//            "1 0 北京总部,3 1 研发中心,4 3 后端研发组,6 4 后端实习生组,7 3 前端研发组,8 1 产品部", "8,7",  "1",
            "1 0 北京总部,3 1 研发中心,4 3 后端研发组,6 4 后端实习生组,7 3 前端研发组,8 1 产品部", "6,7",  "3"
    }, argumentsCount = 3, argumentsParsers = {
            StringsArgumentsParser.class,
            IntsArgumentsParser.class,
            IntArgumentsParser.class
    }, delimiter = ",")
    void doSolve(String[] source, int[] departmentIds, int expected) {
        Integer actual = Solver.solve(LatestCommonDep.class, source, departmentIds);
        assertEquals(expected, actual);
    }
}
