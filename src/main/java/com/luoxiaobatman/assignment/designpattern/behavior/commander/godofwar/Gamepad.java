package com.luoxiaobatman.assignment.designpattern.behavior.commander.godofwar;

import com.luoxiaobatman.assignment.designpattern.behavior.commander.Command;
import com.luoxiaobatman.assignment.designpattern.behavior.commander.Invoker;

public interface Gamepad extends Invoker {
    @Override
    default void invoke(Command command) {

    };

    /**
     * 方向键集合
     */
    void move();

    /**
     * X(下) 按钮
     */
    void cross();

    /**
     * 正方形(左) 按钮
     */
    void square();

    /**
     * 三角形(上) 按钮
     */
    void triangle();

    /**
     * 圆(右) 按钮
     */
    void circle();
}
