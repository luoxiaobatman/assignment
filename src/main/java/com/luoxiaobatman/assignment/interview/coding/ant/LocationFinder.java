package com.luoxiaobatman.assignment.interview.coding.ant;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.DefaultAnswer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;

import java.util.Objects;

/**
 * 二分
 * single thread
 */
public class LocationFinder implements Solution {
    private final int[] array;
    private final int m;
    public LocationFinder(int[] array, int m) {
        this.array = array;
        this.m = m;
    }

//    @NotNull
    @Override
    public Answer solve() {
        Answer answer = Factory.of(Answer.class).newInstance(DefaultAnswer.class);
        int notFound = -1;
        answer.setAnswer(notFound);
        int[] array = this.array;
        int m = this.m;

        if (Objects.isNull(array) || array.length == 0) {
            answer.setAnswer(notFound);
            return answer;
        }
        int l = array.length;
        int lastIndex = l - 1;
        int firstIndex = 0;
        int lastIndexValue = array[lastIndex];
        if (m > lastIndexValue) {
            return answer;
        }
        int firstIndexValue = array[firstIndex];
        while (true) {
            if (m < firstIndexValue) {
                answer.setAnswer(firstIndex);
                return answer;
            }
            if (l <= 1) {
                answer.setAnswer(lastIndex);
                return answer;
            }
            int middle = (lastIndex - firstIndex) / 2 + firstIndex;
            int middleValue = array[middle];

            if (middleValue >= m) {
                lastIndex = middle;
            }
            if (middleValue < m) {
                firstIndex = middle;
                firstIndexValue = middleValue;
            }
            l = lastIndex - firstIndex;
        }
    }
}
