package com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.topic;

import java.time.Duration;

public interface Topic {
    /**
     * 设置分区数
     */
    void setPartitionCount(int n);

    /**
     * 管理员为每个主题配置了数据保留期限
     *
     * 规定数据被删除之前可以保留多长时间，或者清理数据之前可以保留的数据量大小。
     */
    void dataTTL(Duration duration);
}
