package com.luoxiaobatman.assignment.leetcode.trivial;

public class Util {
    public static void swap(int[] source, int i, int j) {
        if (i == j) return;
        int tmp = source[i];
        source[i] = source[j];
        source[j] = tmp;
    }
}
