package com.luoxiaobatman.assignment.interview.systemdesign.component.kafka;

import com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.topic.Topic;

public interface KafkaConsumer {
    /**
     * 生产者关联kafka实例的某个主题
     * @param kafkaCluster
     */
    void register(KafkaCluster kafkaCluster, Topic topic);

    /**
     * 消费消息
     */
    void consume(Message message);
}
