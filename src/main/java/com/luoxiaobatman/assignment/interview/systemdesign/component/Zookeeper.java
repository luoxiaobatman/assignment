package com.luoxiaobatman.assignment.interview.systemdesign.component;

import com.luoxiaobatman.assignment.interview.systemdesign.Stateful;
import com.luoxiaobatman.assignment.interview.systemdesign.protocol.ZAB;
import com.luoxiaobatman.assignment.interview.systemdesign.svc.ConfigSVC;
import com.luoxiaobatman.assignment.interview.systemdesign.trait.Distributed;
import com.luoxiaobatman.assignment.interview.systemdesign.trait.HorizontalScalable;

public class Zookeeper implements ConfigSVC, Stateful, Distributed, HorizontalScalable, ZAB {
}
