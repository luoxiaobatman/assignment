package com.luoxiaobatman.assignment.unclassified;


import java.util.Properties;

/**
 * 32位虚拟机
 */
public class LongIsNotAtomic {
    public static long MAX = 1L << 63;
    private long a = 0L;

    public void set() {
        a = 1L << 63;
    }

    public long get() {
        return a;
    }

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        String p = System.getProperty("sun.arch.data.model");
        System.out.println(p);
    }
}
