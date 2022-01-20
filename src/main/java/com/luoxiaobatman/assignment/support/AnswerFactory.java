package com.luoxiaobatman.assignment.support;

import com.luoxiaobatman.assignment.solution.Answer;

public class AnswerFactory extends StandardFactory<Answer> implements Factory<Answer>{
    private static AnswerFactory instance;

    public static AnswerFactory getInstance() {
        if (instance == null) {
            synchronized (AnswerFactory.class) {
                if (instance == null) {
                    instance = new AnswerFactory();
                }
            }
        }
        return instance;
    }

    public AnswerFactory() {
        super(Answer.class);
    }
}
