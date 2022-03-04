package com.luoxiaobatman.assignment.leetcode.milestone.spring2022;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import com.luoxiaobatman.assignment.util.Bits;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class P000
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[] sources;

    @Override
    public Integer doSolve() {
        int result = sources[0];
        for (int i = 1; i < sources.length; i++) {
            result = result ^ sources[i];
        }
        return result;
    }
}
