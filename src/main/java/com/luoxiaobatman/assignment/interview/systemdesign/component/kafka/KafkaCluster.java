package com.luoxiaobatman.assignment.interview.systemdesign.component.kafka;

import com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.topic.Topic;

import java.util.Set;

/**
 * 用Kafka演示观察者模式
 * <p>
 * 根据官网介绍, 高可靠, 高可用, 分布式的消息通道
 */
public class KafkaCluster {
    /**
     * 集群中的topics
     */
    Set<Topic> topics;

    /**
     * 集群中的实例
     */
    Set<Partition> partitions;

    /**
     * 启动Kafka集群
     */
    void start() {

    }

}
