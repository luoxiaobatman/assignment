package com.luoxiaobatman.assignment.designpattern.behavior.filterchain.leek;

import com.luoxiaobatman.assignment.designpattern.behavior.commander.Command;
import com.luoxiaobatman.assignment.designpattern.behavior.filterchain.Filter;

/**
 * 消费主义 割韭菜
 */
public class Consumerism implements Cutter {
    @Override
    public boolean cut(Leek leek) {
        profit(leek);
        return true;
    }

    private void profit(Leek leek) {}
}
