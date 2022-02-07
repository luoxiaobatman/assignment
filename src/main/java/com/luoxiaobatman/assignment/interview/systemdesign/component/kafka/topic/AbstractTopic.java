package com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.topic;

public class AbstractTopic {
    /**
     * 主题的复制系数
     * 每个分区总会被N个不同的broker复制
     * 默认3
     * @see com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.broker.AbstractBroker#replicationFactor
     */
    private int replicationFactor;

    /**
     * 最少同步副本
     * <p>
     * 消息只有在被写入到所有同步副本之后才被认为是已提交
     */
    private int minInsyncReplicas;
}
