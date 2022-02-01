package com.luoxiaobatman.assignment.designpattern.behavior.filterchain.leek;

import com.luoxiaobatman.assignment.designpattern.behavior.commander.Command;
import com.luoxiaobatman.assignment.designpattern.behavior.filterchain.Filter;

/**
 * PUA 割韭菜
 */
public class PUA implements Cutter {
    @Override
    public boolean cut(Leek leek) {
        manipulate(leek);
        return true;
    }

    void manipulate(Leek leek) {}
}
