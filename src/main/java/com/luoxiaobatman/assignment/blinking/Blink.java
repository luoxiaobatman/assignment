package com.luoxiaobatman.assignment.blinking;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.SubstituteLoggerFactory;

import javax.annotation.RegEx;
import java.io.*;
import java.time.LocalTime;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解除劳动合同  √
 * 聘用函纸质1份 √
 * 招行银行卡    √
 * 保密协议纸质2份 √
 * 原公司三个月流水, 纸质 √
 * ---
 * 体检报告
 * 学历学位身份证正反面, 各两份
 * 三张白底彩色寸照
 */
@Slf4j
public class Blink {
    private static class T {
//        private long p0, p1, p2, p3, p4, p5, p6, p7;
        public long c = 0L;
//        private long p9, p10, p11, p12, p13, p14, p15;
    }

    public static T[] ts = new T[2];
    static {
        ts[0] = new T();
        ts[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
//        T[] ts = new T[2];
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1e9; i++) {
                ts[0].c = i;
            }
            latch.countDown();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1e9; i++) {
                ts[1].c = i;
            }
            latch.countDown();
        });
        long start = System.nanoTime();
        t1.start();
        t2.start();
        latch.await();
        System.out.println((System.nanoTime() - start) / 1e7);
    }
}
