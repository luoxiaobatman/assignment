package com.luoxiaobatman.assignment.designpattern.behavior.filterchain.leek;

import com.luoxiaobatman.assignment.designpattern.behavior.commander.Command;
import com.luoxiaobatman.assignment.designpattern.behavior.filterchain.Filter;

public interface Cutter extends Filter {
    @Override
    default boolean applyFor(Command command) {
        if (command instanceof Leek) {
            return cut((Leek) command);
        }
        return false;
    }

    boolean cut(Leek leek);
}
