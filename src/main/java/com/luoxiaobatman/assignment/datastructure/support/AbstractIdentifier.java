package com.luoxiaobatman.assignment.datastructure.support;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractIdentifier implements Identifier {
    /**
     * identifier 携带的附加信息
     */
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

    /**
     * 按照string的charAt来进行比较, codepoint更小
     * <p>
     * 如果相同, 则string.length()小的在前
     */
    @Override
    public int compareTo(@NotNull Identifier identifier) {
        String pre = id();
        String after = identifier.id();
        int range = Math.min(pre.length(), after.length());
        for (int i = 0; i < range; i++) {
            if (pre.charAt(i) < after.charAt(i)) {
                return -1;
            }
            if (pre.charAt(i) > after.charAt(i)) {
                return 1;
            }
        }
        return Integer.compare(pre.length(), after.length());
    }
}
