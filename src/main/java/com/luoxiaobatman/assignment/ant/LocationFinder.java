package com.luoxiaobatman.assignment.ant;

import com.luoxiaobatman.assignment.solution.Solution;

import java.util.Objects;

/**
 * 二分
 * single thread
 */
public class LocationFinder implements Solution<Integer> {
    private final int[] array;
    private final int m;
    public LocationFinder(int[] array, int m) {
        this.array = array;
        this.m = m;
    }

//    @NotNull
    @Override
    public Integer solve() {
        int[] array = this.array;
        int m = this.m;

        int notFound = -1;
        if (Objects.isNull(array) || array.length == 0) {
            return notFound;
        }
        int l = array.length;
        int lastIndex = l - 1;
        int firstIndex = 0;
        int lastIndexValue = array[lastIndex];
        if (m > lastIndexValue) {
            return notFound;
        }
        int firstIndexValue = array[firstIndex];
        while (true) {
            if (m < firstIndexValue) {
                return firstIndex;
            }
            if (l <= 1) {
                return lastIndex;
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
