package com.luoxiaobatman.assignment.datastructure.support;

public class StringIdentifier extends AbstractIdentifier implements Identifier{
    private final String id;

    public StringIdentifier(String id) {
        this.id = id;
    }

    @Override
    public String id() {
        return id;
    }
}
