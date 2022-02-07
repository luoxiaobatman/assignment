package com.luoxiaobatman.assignment.interview.systemdesign.component.kafka;

import com.luoxiaobatman.assignment.interview.systemdesign.component.kafka.topic.Topic;

public interface Message {
    /**
     * @param topic 消息属于的topic
     */
    void setTopic(Topic topic);
}
