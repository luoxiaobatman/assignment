package com.luoxiaobatman.assignment.blackbox;

public class StackOverflow {
    private static void overflow() {
        overflow();
    }

    public static void main(String[] args) {
        overflow();
    }
}
