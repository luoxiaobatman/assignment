package com.luoxiaobatman.assignment.designpattern.behavior.filterchain.leek;

import com.luoxiaobatman.assignment.designpattern.behavior.commander.Command;
import com.luoxiaobatman.assignment.designpattern.behavior.commander.Receiver;

/**
 * 韭菜
 */
public class Leek implements Command {
    /**
     * 秃了
     */
    private boolean isBald;

    public boolean isBald() {
        return isBald;
    }

    /**
     * 韭菜在生产出来就
     * @param receiver
     */
    @Override
    public void execute(Receiver receiver) {
        receiver.act();
    }
}
