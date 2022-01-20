package com.luoxiaobatman.assignment;

import sun.misc.Unsafe;

import java.lang.ref.Cleaner;
import java.nio.channels.AsynchronousSocketChannel;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static final Instance instance = new Instance();
//    static class InstanceHolder {
//    }
    static class Instance {
        public Instance() {
            System.out.println("<init>");
        }
    }

    public static void main(String[] args) {
        System.out.println(
            new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZ yyyy", Locale.ENGLISH).format(new Date())
        );
    }
}
