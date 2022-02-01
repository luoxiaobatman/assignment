package com.luoxiaobatman.assignment.designpattern.behavior.filterchain;

import com.luoxiaobatman.assignment.designpattern.behavior.commander.Command;

/**
 * bonus
 * <p>
 * 1条filter chain 变 n 条
 */
public interface Dispatcher extends Filter {
    @Override
    default boolean applyFor(Command command) {
        dispatch(command);
        return false;
    }

    void dispatch(Command command);
}
