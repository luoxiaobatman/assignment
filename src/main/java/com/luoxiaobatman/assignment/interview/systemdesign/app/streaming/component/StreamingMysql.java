package com.luoxiaobatman.assignment.interview.systemdesign.app.streaming.component;

import com.luoxiaobatman.assignment.interview.systemdesign.component.MysqlInno;
import com.luoxiaobatman.assignment.interview.systemdesign.trait.Distributed;
import com.luoxiaobatman.assignment.interview.systemdesign.trait.MasterSlave;
import com.luoxiaobatman.assignment.interview.systemdesign.trait.Sharding;

/**
 * mysql实例
 */
public class StreamingMysql extends MysqlInno implements Sharding, Distributed, MasterSlave {
}
