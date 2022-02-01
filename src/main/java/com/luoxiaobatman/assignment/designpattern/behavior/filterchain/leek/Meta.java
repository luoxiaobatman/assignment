package com.luoxiaobatman.assignment.designpattern.behavior.filterchain.leek;

import com.luoxiaobatman.assignment.designpattern.behavior.commander.Receiver;

public class Meta implements Cutter {
    private Receiver buyer = new Buyer();

    @Override
    public boolean cut(Leek leek) {
        lie(leek);
        // 割韭菜这茬没秃, 就代表我没割
        return !leek.isBald();
    }

    private void lie(Leek leek) {
        leek.execute(buyer);

    };
}
