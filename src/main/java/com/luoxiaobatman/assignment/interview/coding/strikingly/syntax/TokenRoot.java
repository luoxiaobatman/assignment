package com.luoxiaobatman.assignment.interview.coding.strikingly.syntax;

import com.luoxiaobatman.assignment.interview.coding.strikingly.syntax.Token;

import java.util.ArrayList;
import java.util.List;

public class TokenRoot implements Token {
    private List<Token> children = new ArrayList<>();

    public List<Token> getChildren() {
        return children;
    }
}
