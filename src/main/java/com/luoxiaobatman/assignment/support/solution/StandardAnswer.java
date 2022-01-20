package com.luoxiaobatman.assignment.support.solution;

public class StandardAnswer<T> implements GenericAnswer<T> {
    private T answer;

    @Override
    public T getAnswer() {
        return answer;
    }

    @Override
    public void setAnswer(T answer) {
        this.answer = answer;
    }
}
