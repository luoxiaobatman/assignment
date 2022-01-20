package com.luoxiaobatman.assignment.support.solution;

import com.luoxiaobatman.assignment.support.solution.GenericSolutionFactory;

/**
 * Facade
 */
public class Solver {
    public static <T> T solve(Class<? extends GenericSolution<T>> c, Object... args) {
        return GenericSolutionFactory
                .getInstance(c)
                .newInstance(args)
                .solve()
                .getAnswer();
    }
}
