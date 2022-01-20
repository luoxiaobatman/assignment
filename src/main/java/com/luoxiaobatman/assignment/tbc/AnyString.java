package com.luoxiaobatman.assignment.tbc;

/**
 *
 */
public class AnyString {

    /**
     * .length() 很粗暴 O(1)
     * .codePointCount() 符合直觉, O(N)
     */
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
