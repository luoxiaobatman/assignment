package com.luoxiaobatman.assignment.datastructure.support;

/**
 * 唯一索引
 */
public interface Identifier {
    String id();

    boolean equals(Object obj);

    int hashCode();

    String toString();

    Object mark();
    void mark(Object mark);
}
