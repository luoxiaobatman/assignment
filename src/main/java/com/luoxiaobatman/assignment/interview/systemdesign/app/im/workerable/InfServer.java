package com.luoxiaobatman.assignment.interview.systemdesign.app.im.workerable;

import com.luoxiaobatman.assignment.interview.systemdesign.app.im.Message;
import com.luoxiaobatman.assignment.interview.systemdesign.app.im.Server;

import java.util.List;

/**
 * 一台拥有无穷并发的im服务器
 *
 * 无论并发量多高, 处理一个请求总是消耗1ms
 */
public final class InfServer implements Server {
    private InfMysql infMysql;


    @Override
    public void createMessage(Message message) {

    }

    @Override
    public void friend(long cuid, long ouid, int flag) {

    }

    @Override
    public void message(Message message, int flag) {

    }

    @Override
    public List<Message> pull(long cuid) {
        return null;
    }
}
