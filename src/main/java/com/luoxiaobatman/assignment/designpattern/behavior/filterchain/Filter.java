package com.luoxiaobatman.assignment.designpattern.behavior.filterchain;

import com.luoxiaobatman.assignment.designpattern.behavior.commander.Command;

/**
 * alias: chain of responsibility
 */
public interface Filter {
    boolean applyFor(Command command);
}
