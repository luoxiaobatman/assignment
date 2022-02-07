package com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.producer;

public interface Producer {
    /**
     * 重新发送, 针对Broker返回的特定错误, 可以进行重试
     *
     * 譬如 LeaderNotAvailable
     */
    void retry();
}
