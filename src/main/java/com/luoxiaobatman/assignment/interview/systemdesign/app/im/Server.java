package com.luoxiaobatman.assignment.interview.systemdesign.app.im;

import java.util.List;

public interface Server {
    void createMessage(Message message);

    /**
     * 功能: 好友 crud
     */
    void friend(long cuid, long ouid, int flag);

    /**
     * 功能: 消息发送 (单+群)
     */
    void message(Message message, int flag);

    /**
     * 功能: 聊天列表
     */
    List<Message> pull(long cuid);
}
