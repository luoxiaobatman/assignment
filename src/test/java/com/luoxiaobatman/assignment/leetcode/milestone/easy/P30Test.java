package com.luoxiaobatman.assignment.leetcode.milestone.easy;

import com.luoxiaobatman.assignment.leetcode.ListNode;
import com.luoxiaobatman.assignment.support.SolutionSource;
import com.luoxiaobatman.assignment.support.solution.Solver;
import com.luoxiaobatman.assignment.util.ListNodeUtils;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class P30Test {

    @ParameterizedTest
    @SolutionSource(value = {
//            "barfoothefoobarman", "foo,bar", "0,9",
//            "barfoofoobarthefoobarman", "bar,foo,the", "6,9,12",
            "wordgoodgoodgoodbestword", "word,good,best,good", "8",
    })
    void doSolve(String s, String[] words, int[] expected) {
        int[] actual = Solver.solve(P30.class, s, words);
        assertArrayEquals(expected, actual);
    }
}
