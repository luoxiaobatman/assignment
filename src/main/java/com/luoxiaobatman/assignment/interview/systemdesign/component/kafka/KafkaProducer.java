package com.luoxiaobatman.assignment.interview.systemdesign.component.kafka;

import com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.topic.Topic;

public interface KafkaProducer {
    /**
     * 生产者关联kafka实例的某个主题
     * @param kafkaCluster
     */
    void connect(KafkaCluster kafkaCluster, Topic topic);

    /**
     * 向关联主题写消息
     */
    void produce(Message message);
}
