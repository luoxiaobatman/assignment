package com.luoxiaobatman.assignment.support;

import com.luoxiaobatman.assignment.solution.Solution;


public class SolutionFactory extends StandardFactory<Solution> implements Factory<Solution> {
    private static SolutionFactory instance;

    public static SolutionFactory getInstance() {
        if (instance == null) {
            synchronized (SolutionFactory.class) {
                if (instance == null) {
                    instance = new SolutionFactory();
                }
            }
        }
        return instance;
    }

    public SolutionFactory(Class<? extends Solution> cType) {
        super(Solution.class, cType);
    }

    public SolutionFactory() {
        super(Solution.class);
    }
}
