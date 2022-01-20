package com.luoxiaobatman.assignment.support.solution;

import com.luoxiaobatman.assignment.support.Default;

@Default(StandardAnswer.class)
public interface GenericAnswer<T> {
    T getAnswer();

    void setAnswer(T answer);
}
