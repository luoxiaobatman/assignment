package com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.consumer;

public class AbstractConsumer {
    /**
     * 消费者所属群组
     * <p>
     * 如果消费者同属同一个群组, 并且消费同一个主题, 那么某个消费者只会得到主题消息的一部分.
     */
    private int groupId;

    /**
     * 在没有偏移量可提交时（比如消费者第 1 次启动时）或者请求的偏移量在 broker 上不存在时, 消费者会做些什么
     * <p>
     * earliest ，如果选择了这种配置，消费者会从分区的开始位置读取数据，不管偏移量是否有效，这样会导致消费者读取大量的重复数据，但可以保证最少的数据丢失。
     * <p>
     * 一种是 latest ，如果选择了这种配置，消费者会从分区的末尾开始读取数据，这样可以减少重复处理消息，但很有可能会错过一些消息。
     */
    private String autoOffsetReset;

    /**
     * 让消费者基于任务调度自动提交偏移量，也可以在代码里手动提交偏移量。
     */
    private boolean enableAutoCommit;

    /**
     * 自动提交偏移量的间隔
     * <p>
     * 默认每5秒提交一次
     */
    private int autoCommitIntervalMs;
}
