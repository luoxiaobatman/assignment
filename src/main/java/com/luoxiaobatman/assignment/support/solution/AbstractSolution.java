package com.luoxiaobatman.assignment.support.solution;

/**
 * Template
 * @param <T> answer
 */
public abstract class AbstractSolution<T> implements GenericSolution<T> {
    /**
     * 骨架
     */
    @Override
    public GenericAnswer<T> solve() {
        StandardAnswer<T> answer = new StandardAnswer<>();
        answer.setAnswer(doSolve());
        return answer;
    }

    /**
     * 细节
     * @return rawAnswer
     */
    public abstract T doSolve();
}
