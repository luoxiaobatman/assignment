package com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.broker;

public class AbstractBroker {
    /**
     * 自动创建的主题的复制系数
     * 每个分区总会被N个不同的broker复制
     * 默认3
     *
     * @see com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.topic.AbstractTopic#replicationFactor
     */
    private int replicationFactor;

    /**
     * 不完全选举
     * <p>
     * 描述broker挂了后, broker上的partition的主replica与副replica数据不同步, 的行为
     * <p>
     * 面临消息丢失的风险, 但是增加了可用性
     */
    private boolean uncleanLeaderElection;

    /**
     * 最少同步副本
     * <p>
     * 消息只有在被写入到所有同步副本之后才被认为是已提交
     */
    private int minInsyncReplicas;

}
