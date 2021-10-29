package com.luoxiaobatman.assignment.blackbox;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassloader {
    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file:///Users/xiaoluo/")});
        Class<?> aClass = urlClassLoader.loadClass("com.luoxiaobatman.assignment.blackbox.Foo");
        System.out.println(aClass);
    }
}
