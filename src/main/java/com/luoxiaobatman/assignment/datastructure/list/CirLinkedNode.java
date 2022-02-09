package com.luoxiaobatman.assignment.datastructure.list;

import lombok.Data;
import lombok.NonNull;

/**
 * 循环链表
 */
@Data
public class CirLinkedNode<D> {
    @NonNull
    private CirLinkedNode<D> next;
    private D data;
}
