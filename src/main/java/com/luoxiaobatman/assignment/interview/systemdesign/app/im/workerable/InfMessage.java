package com.luoxiaobatman.assignment.interview.systemdesign.app.im.workerable;

import com.luoxiaobatman.assignment.interview.systemdesign.app.im.Message;

public class InfMessage implements Message {
    /**
     * 消息发送方
     */
    long cuid;

    /**
     * 消息接收方
     */
    long ouid;

    /**
     * 消息体
     */
    String content;

    @Override
    public void setSender(long cuid) {

    }

    @Override
    public void setReceiver(long ouid) {

    }

    @Override
    public void setGroup(long gid) {

    }
}
