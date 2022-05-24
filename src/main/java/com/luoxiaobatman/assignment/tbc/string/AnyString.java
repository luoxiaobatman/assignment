package com.luoxiaobatman.assignment.tbc.string;

/**
 * representation and interpretation
 *
 * change history
 *
 * compiler optimization
 *   constant folding
 *
 * related algorithm&structure and there's big usages
 *   editing length: search engine(word suggest)
 *   KMP: word find
 *   trie
 *   digest and cipher
 */
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
