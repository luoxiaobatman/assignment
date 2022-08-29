package com.luoxiaobatman.assignment.interview.coding.strikingly.syntax;

import java.util.ArrayList;
import java.util.List;

public class TokenPrefixSuffix implements Token {
    private final List<Token> children = new ArrayList<>();

    public final int prefixIndex;
    public final int suffixIndex;

    public TokenPrefixSuffix(int prefixIndex, int suffixIndex) {
        this.prefixIndex = prefixIndex;
        this.suffixIndex = suffixIndex;
    }

    @Override
    public List<Token> getChildren() {
        return children;
    }
}
