package com.luoxiaobatman.assignment.blackbox.string;

import java.nio.charset.StandardCharsets;

public class Encoding {
    public static void main(String[] args) {
//        char[] chars = "𝄞".toCharArray();
        String s = new String("罗".getBytes(StandardCharsets.UTF_8));
        System.out.println(s);
    }
}
