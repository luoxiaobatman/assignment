package com.luoxiaobatman.assignment.interview.systemdesign.component.kafka;

import com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.broker.Broker;

public interface Replica {
    /**
     * @return 副本所在kafka实例
     */
    Partition partition();

    /**
     * 该副本存放在哪个broker里面
     */
    Broker broker();

    /**
     * 选取副本的leader
     */
    void chooseLeader();
}
