package com.luoxiaobatman.assignment.blackbox.objecthead;

import org.openjdk.jol.info.ClassLayout;

import java.util.List;
import java.util.Queue;

/**
 * 简单打印对象头, 看看里面是什么
 * 数组对象头多了 len
 * 锁升级一目了然
 * hashcode的延迟计算
 */
public class Markword {
    public static void run(Markword markword) throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (markword) {
                System.out.println(ClassLayout.parseInstance(markword).toPrintable());
            }
            System.out.println(ClassLayout.parseInstance(markword).toPrintable());
        });
        thread.start();
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
//        int[] ints = new int[10];
//        System.out.println(ClassLayout.parseInstance(ints).toPrintable());

        Markword markword = new Markword();
        markword.hashCode();
        System.out.println(ClassLayout.parseInstance(markword).toPrintable());
//        synchronized (markword) {
//            System.out.println(ClassLayout.parseInstance(markword).toPrintable());
//        }
//        System.out.println(ClassLayout.parseInstance(markword).toPrintable());
//        run(markword);
    }
}
