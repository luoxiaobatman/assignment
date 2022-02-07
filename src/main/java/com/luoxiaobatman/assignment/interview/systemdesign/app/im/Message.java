package com.luoxiaobatman.assignment.interview.systemdesign.app.im;

public interface Message {
    /**
     * 设置消息的发送者
     */
    void setSender(long cuid);

    /**
     * 设置消息的接受者
     */
    void setReceiver(long ouid);

    /**
     * 设置消息的接受群
     */
    void setGroup(long gid);
}
