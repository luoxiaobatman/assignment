package com.luoxiaobatman.assignment.interview.coding.strikingly.syntax;

import java.util.List;

public class TokenLiteral implements Token {
    public final String literal;

    public TokenLiteral(String literal) {
        this.literal = literal;
    }

    @Override
    public List<Token> getChildren() {
        return null;
    }
}
