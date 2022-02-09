package com.luoxiaobatman.assignment.datastructure.list;

public class DoubleLinkedNode<D> {
    private DoubleLinkedNode<D> prev;
    private DoubleLinkedNode<D> next;

    public DoubleLinkedNode<D> getPrev() {
        return prev;
    }

    public DoubleLinkedNode<D> getNext() {
        return next;
    }

    public D getData() {
        return data;
    }

    private D data;

    public DoubleLinkedNode(D data) {
        this.data = data;
    }


    /**
     * 将自身从链表的节点中删除
     */
    public void removeSelf() {
        if (prev == this && next == this) {
            return;
        }

        if (prev != null) {
            prev.setNext(next);
        }
        if (next != null) {
            next.setPrev(prev);
        }
    }

    public void setNext(DoubleLinkedNode<D> next) {
        this.next = next;
    }

    public void setPrev(DoubleLinkedNode<D> prev) {
        this.prev = prev;
    }
}
