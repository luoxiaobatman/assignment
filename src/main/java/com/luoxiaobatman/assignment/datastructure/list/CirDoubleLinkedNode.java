package com.luoxiaobatman.assignment.datastructure.list;

import lombok.Data;
import lombok.NonNull;

@Data
public class CirDoubleLinkedNode<D> {
    @NonNull
    private CirDoubleLinkedNode<D> prev;
    @NonNull
    private CirDoubleLinkedNode<D> next;
    private D data;
}
