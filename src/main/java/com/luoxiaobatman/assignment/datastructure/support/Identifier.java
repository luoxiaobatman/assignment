package com.luoxiaobatman.assignment.datastructure.support;

/**
 * 唯一索引, 一般附加在数据结构的节点上
 * <p>
 * 使数据结构更加通用
 */
public interface Identifier extends Comparable<Identifier> {
    String id();

    boolean equals(Object obj);

    int hashCode();

    String toString();

    Object mark();

    void mark(Object mark);
}
