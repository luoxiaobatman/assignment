package com.luoxiaobatman.assignment.tbc.string;

public class AnyString {

    private void lengthTest() {
//        String s = "\uD834\uDD1E";
        String s = "𝄞";
        System.out.println(s.length());
        System.out.println(s.codePointCount(0, 2));
    }

    public static void main(String[] args) {
        AnyString anyString = new AnyString();
        anyString.lengthTest();
    }
}
