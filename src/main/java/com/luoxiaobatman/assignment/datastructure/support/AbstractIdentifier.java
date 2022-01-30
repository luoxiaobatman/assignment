package com.luoxiaobatman.assignment.datastructure.support;

public abstract class AbstractIdentifier implements Identifier {
    private Object mark;

    public Object mark() {
        return mark;
    }
    public void mark(Object m) {
        this.mark = m;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Identifier other)) {
            return false;
        }
        return id().equals(other.id());
    }

    @Override
    public int hashCode() {
        return id().hashCode();
    }

    @Override
    public String toString() {
        return id();
    }
}
