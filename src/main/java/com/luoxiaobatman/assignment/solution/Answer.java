package com.luoxiaobatman.assignment.solution;

import com.luoxiaobatman.assignment.support.Default;
import com.luoxiaobatman.assignment.support.Invoker;

@Invoker
@Default(DefaultAnswer.class)
public interface Answer {
    Object getAnswer();

    void setAnswer(Object answer);
}
