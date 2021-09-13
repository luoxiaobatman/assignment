package com.luoxiaobatman.assignment.huawei.autumn2021;

import java.util.*;

/**
 * 时间复杂度 O(1)
 * map size巨大的时候, 扩容, rehash都是巨量消耗
 * 线程不安全
 *
 * ip黑/白名单工具接口, 请实现一个基于内存的ip黑/白名单具体实现
 * 程序设计上，让此工具所能支持的ip列表数量尽可能大, 内存占用尽可能小，运行尽可能快；
 */
public class IpFilterHashMap {
    private final Map<String, Short> blackAndWhite = new HashMap<>() ;

    /**
     * 设置指定的ipv4地址进入名单
     *
     * @param ip(以*.*.*.*格式的ipv4字符串)
     * @param ipType(1白名单，2黑名单)
     */
    public void setIpInList(String ip, int ipType) {
        blackAndWhite.put(ip, (short) ipType);
    }

    /**
     * 判断指定的ipv4地址是否在当前名单中
     *
     * @param ip(以*.*.*.*格式的ipv4字符串)
     * @return 1：在白名单中， 2: 在黑名单中， 0: 不在名单中
     */
    public int isInList(String ip) {
        return blackAndWhite.getOrDefault(ip, (short) 0);
    }
}
