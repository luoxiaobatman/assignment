package com.luoxiaobatman.assignment.designpattern.behavior.iterator.diablo3;

import java.util.Iterator;

public class GreaterRift implements Iterator<Rift> {

    /**
     * grinding never ends
     */
    @Override
    public boolean hasNext() {
        return true;
    }

    /**
     * 大秘境随机一张图
     */
    @Override
    public Rift next() {
        return new Rift();
    }
}
