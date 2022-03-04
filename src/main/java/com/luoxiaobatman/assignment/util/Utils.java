package com.luoxiaobatman.assignment.util;

import java.util.List;

public class Utils {
    public static<T> T[] listToArray(List<T> list) {
        if (list == null) return null;
        T[] objects = (T[]) list.toArray();
        return objects;
    }
}
