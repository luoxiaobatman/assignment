package com.luoxiaobatman.assignment.blackbox.operator;

public class Operators {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.setDaemon(true);
        thread.interrupt();
//        System.out.println(1 << 1);
        System.out.println(-2 | 3);
    }
}
