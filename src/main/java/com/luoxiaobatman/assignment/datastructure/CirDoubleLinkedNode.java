package com.luoxiaobatman.assignment.datastructure;

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
