package com.luoxiaobatman.assignment.datastructure.support;

import org.jetbrains.annotations.NotNull;

public class IntegerIdentifier extends AbstractIdentifier implements Identifier {
    private int i;

    public IntegerIdentifier(int id) {
        i = id;
    }

    @Override
    public String id() {
        return String.valueOf(i);
    }

    @Override
    public int compareTo(@NotNull Identifier identifier) {
        return this.i - Integer.parseInt(identifier.id());
    }
}
