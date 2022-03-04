package com.luoxiaobatman.assignment.util;

public class Bits {
    public static int xor(int a, int b) {
        return (a | b) - (a & b);
    }
}
