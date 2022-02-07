package com.luoxiaobatman.assignment.designpattern.behavior.observer;


/**
 * GoF 书上介绍的Observer模式, jdk 失败 案列
 *
 * @see java.util.Observer
 * @see java.util.Observable
 */
public interface Observer {
    void update(String event);
}
