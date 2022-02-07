package com.luoxiaobatman.assignment.interview.systemdesign.app.im;

/**
 * <pre>
 *     缩写
 *     M = Million
 *     B = Billion
 *     m = message 一条消息
 *     s = second
 *     dau = 日活
 *     d = day
 *     p = person
 * </pre>
 * <pre>
 *     功能
 *     1.好友 crud
 *     2.消息发送 (单+群)
 *     3.聊天列表
 *     4.多设备
 *     5.消息漫游
 *     6.已读未读
 * </pre>
 * <pre>
 *     约束
 *     1B dau
 *     100m / d * p -> 100 * 1B / 86400 = 12M/s
 *     1kb / m -> 1 pb / day
 *     可靠性5个9
 *     消息收发延迟10ms
 *     消息时序一致
 *     10k 群聊
 *     运维
 * </pre>
 *
 */
public class IM {
    public static void main(String[] args) {
    }
}
