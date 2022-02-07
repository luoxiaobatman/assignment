package com.luoxiaobatman.assignment.interview.systemdesign.app.im;

import com.luoxiaobatman.assignment.interview.systemdesign.app.im.Message;

import java.util.List;

public interface Client {
    void send(Message message);
    List<Message> pull();
}
