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

    /**
     * 泛型擦除, Class不带泛型, 爷很伤...
     * <p>
     * ConcreteSolution< E > implements GenericSolution< Object >
     * 这种无法直接作为solve的第一个参数
     */
    public static <T> T solveAny(Class<?> c, Object... args) {
        return GenericSolutionFactory
                .getInstance((Class<? extends GenericSolution<T>>) c)
                .newInstance(args)
                .solve()
                .getAnswer();
    }
}
