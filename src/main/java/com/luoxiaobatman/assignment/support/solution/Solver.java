package com.luoxiaobatman.assignment.support.solution;

/**
 * Facade
 */
public class Solver {
    /**
     * Generify
     */
    public static <T> T solve(Class<? extends GenericSolution<T>> c, Object... args) {
        return GenericSolutionFactory
                .getInstance((Class<? extends GenericSolution<T>>) c)
                .newInstance(args)
                .solve()
                .getAnswer();
    }

    public static <T> T solveAny(Class<?> c, Object... args) {
        return GenericSolutionFactory
                .getInstance((Class<? extends GenericSolution<T>>) c)
                .newInstance(args)
                .solve()
                .getAnswer();
    }
}
