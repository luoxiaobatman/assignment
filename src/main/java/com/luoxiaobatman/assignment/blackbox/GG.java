package com.luoxiaobatman.assignment.blackbox;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.Principal;
import java.util.concurrent.Future;

public class GG {
    public static void main(String[] args) throws InterruptedException, IllegalAccessException {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        Unsafe unsafe = (Unsafe) declaredField.get(null);
        System.out.println(unsafe);
    }
    private static void recursive() {
        recursive();
    }
}
