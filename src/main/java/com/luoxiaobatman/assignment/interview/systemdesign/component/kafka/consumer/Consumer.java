package com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.consumer;

/**
 * 只有那些被提交到 Kafka 的数据，也就是那些已经被写入所有同步副本的数据，对消费者是可用的，这意味着消费者得到的消息已经具备了一致性
 * <p>
 * 提交偏移量
 * <p>
 * 丢失消息原因: 提交了偏移量却未能处理完消息
 */
public interface Consumer {
}
