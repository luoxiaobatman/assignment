package com.luoxiaobatman.assignment.datastructure;

import lombok.Data;

/**
 * 链表
 * tail.next == null
 */
@Data
public class LinkedNode<D> {
    private LinkedNode<D> next;
    private D data;
}
