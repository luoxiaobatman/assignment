package com.luoxiaobatman.assignment.interview.systemdesign.component.kafka;

import com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.topic.Topic;

import java.util.Set;

public interface Partition {
    /**
     * 设置副本数量
     */
    void setReplicaCount(int n);

    /**
     * 分区属于哪个Topic
     */
    Topic topic();

    /**
     * @return 分区的所有副本
     */
    Set<Replica> replicas();
}
