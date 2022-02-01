package com.luoxiaobatman.assignment.designpattern.behavior.iterator;


/**
 * @see java.util.Iterator
 */
public interface Iterator<E> {
    boolean hasNext();
    E next();
}
