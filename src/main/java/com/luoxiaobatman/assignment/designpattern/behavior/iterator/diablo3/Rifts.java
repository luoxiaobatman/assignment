package com.luoxiaobatman.assignment.designpattern.behavior.iterator.diablo3;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Container
 */
public class Rifts implements Iterable<Rift> {
    @NotNull
    @Override
    public Iterator<Rift> iterator() {
        return new GreaterRift();
    }
}
