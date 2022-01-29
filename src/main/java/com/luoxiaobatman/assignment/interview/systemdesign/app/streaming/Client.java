package com.luoxiaobatman.assignment.interview.systemdesign.app.streaming;

import com.luoxiaobatman.assignment.interview.systemdesign.LB;
import com.luoxiaobatman.assignment.interview.systemdesign.app.streaming.component.StreamingNginx;
import com.luoxiaobatman.assignment.interview.systemdesign.protocol.l7.Protobuf;

public class Client implements Protobuf {
    private LB loaderBalancer = new StreamingNginx();

    public void requestUserProfile() {
    }
}
