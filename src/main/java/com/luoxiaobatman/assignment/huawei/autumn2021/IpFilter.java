package com.luoxiaobatman.assignment.huawei.autumn2021;

import java.util.Arrays;

/**
 * 思路: 页式内存
 * 4维数组实现
 * 线程安全
 * 为了增加代码可读性, 没有做方法的内联. 编译器优化?
 *
 * ip黑/白名单工具接口, 请实现一个基于内存的ip黑/白名单具体实现
 * 程序设计上，让此工具所能支持的ip列表数量尽可能大, 内存占用尽可能小，运行尽可能快；
 */
public class IpFilter {
    private static volatile IpFilter INSTANCE;

    public static IpFilter instance() {
        if (INSTANCE == null) {
            synchronized (IpFilter.class) {
                if (INSTANCE == null) {
                    INSTANCE = new IpFilter();
                }
            }
        }
        return INSTANCE;
    }

    //    private volatile AtomicLong size = new AtomicLong(0);
    private final int[][][][] ref = new int[256][][][];
    private final Object[] monitors = new Object[256 * 3];

    private IpFilter() {
        // TODO 错误代码, 256 * 3个不同的object
        Arrays.fill(monitors, new Object());
    }

    /**
     * 设置指定的ipv4地址进入名单
     *
     * @param ip(以*.*.*.*格式的ipv4字符串)
     * @param ipType(1白名单，2黑名单)
     * @implNote 大量重复代码->运行尽可能快
     */
    public void setIpInList(String ip, int ipType) {
//        size.incrementAndGet();
        Integer[] idxs = idxs(ip);
        int[][][] intsss;
        int[][] intss;
        int[] ints;
        for (; ; ) {
            intsss = ref[idxs[0]];
            if (intsss == null) {
                synchronized (monitors[idxs[0]]) {
                    if (ref[idxs[0]] != null) continue;
                    initIntsss(ref, idxs, ipType);
                }
                return;
            }
            intss = intsss[idxs[1]];
            if (intss == null) {
                synchronized (monitors[256 + idxs[1]]) {
                    if (intsss[idxs[1]] != null) continue;
                    initIntss(intsss, idxs, ipType);
                }
                return;
            }
            ints = intss[idxs[2]];
            if (ints == null) {
                synchronized (monitors[512 + idxs[2]]) {
                    if (intss[idxs[2]] != null) continue;
                }
                initInts(intss, idxs, ipType);
                return;
            }
            setIpType(ints, idxs, ipType);
            return;
        }
    }

    private void initIntsss(int[][][][] intssss, Integer[] idxs, int ipType) {
        int[][][] intsss = new int[256][][];
        intssss[idxs[0]] = intsss;
        initIntss(intsss, idxs, ipType);
    }

    private void initIntss(int[][][] intsss, Integer[] idxs, int ipType) {
        int[][] intss = new int[256][];
        intsss[idxs[1]] = intss;
        initInts(intss, idxs, ipType);

    }

    private void initInts(int[][] intss, Integer[] idxs, int ipType) {
        int[] ints = new int[16];
        intss[idxs[2]] = ints;
        setIpType(ints, idxs, ipType);
    }

    private void setIpType(int[] ints, Integer[] idxs, int ipType) {
        int page = idxs[3];
        int idx = page / 16;
        int offset = (page % 16) * 2;
        int mask = ipType << offset;
        // TODO bug, 加同步方法
        ints[idx] &= ~(3 << offset);
        ints[idx] |= mask;
    }

    /**
     * split(".") 然后parseInt 方法太慢
     */
    private Integer[] idxs(String ip) {
        Integer[] idxs = new Integer[4];
        int stop = ip.length();
        for (int i = 3; i > -1; i--) {
            stop--;
            char c;
            int mul = 1;
            int parsed = 0;
            while (stop > -1 && (c = ip.charAt(stop)) != '.') {
                parsed = parsed + mul * (c - 48);
                mul = mul * 10;
                stop--;
            }
            idxs[i] = parsed;
        }
        return idxs;
    }


    /**
     * 判断指定的ipv4地址是否在当前名单中
     *
     * @param ip(以*.*.*.*格式的ipv4字符串)
     * @return 1：在白名单中， 2: 在黑名单中， 0: 不在名单中
     */
    public int isInList(String ip) {
        Integer[] idxs = idxs(ip);  // TODO idxs(ip)内联
        try {
            int[] ints = ref[idxs[0]][idxs[1]][idxs[2]];
            int page = idxs[3];
            int idx = page / 16;
            int offset = (page % 16) * 2;
            int mask = 3 << offset;
            int memory = ints[idx];
            return (memory & mask) >>> offset;
        } catch (NullPointerException e) {
            return 0;
        }
    }
//
//    public static void main(String[] args) {
//        IpFilter instance = IpFilter.instance();
//        instance.setIpInList("127.0.0.1", 1);
//        instance.setIpInList("127.0.0.1", 2);
//        instance.setIpInList("192.168.0.2", 2);
//        int inList = instance.isInList("127.0.0.1");
//        int inList2 = instance.isInList("192.168.0.2");
//        System.out.println(inList);
//        System.out.println(inList2);
//    }
}
