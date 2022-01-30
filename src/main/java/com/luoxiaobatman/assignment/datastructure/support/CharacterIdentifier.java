package com.luoxiaobatman.assignment.datastructure.support;

public class CharacterIdentifier extends AbstractIdentifier implements Identifier {
    private char c;

    public CharacterIdentifier(char id) {
        c = id;
    }

    @Override
    public String id() {
        return String.valueOf(c);
    }
}
