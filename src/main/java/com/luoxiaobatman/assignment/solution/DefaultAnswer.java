package com.luoxiaobatman.assignment.solution;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class DefaultAnswer implements Answer {
    private Object answer;

    @Override
    public Object getAnswer() {
        return answer;
    }

    @Override
    public void setAnswer(Object answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return answer.toString();
    }
}
