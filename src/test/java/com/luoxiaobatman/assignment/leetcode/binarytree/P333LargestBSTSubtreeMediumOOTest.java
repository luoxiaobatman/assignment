package com.luoxiaobatman.assignment.leetcode.binarytree;

import com.luoxiaobatman.assignment.support.IntArgumentsParser;
import com.luoxiaobatman.assignment.support.IntegersArgumentsParser;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class P333LargestBSTSubtreeMediumOOTest {
    @ParameterizedTest
    @SolutionSource(value = {
            "10,5,15,1,8,null,7", "3",
            "4,2,7,2,3,5,null,2,null,null,null,null,null,1", "2",
            "3,2,4,null,null,1", "2"
    }, argumentsCount = 2, argumentsParsers = {IntegersArgumentsParser.class, IntArgumentsParser.class}, delimiter = ",")
    void test(Integer[] integers, int expected) {
        Integer solve = Solver.solve(P333LargestBSTSubtreeMediumOO.class, (Object) integers);
        assertEquals(expected, solve);
    }
}
