package com.luoxiaobatman.assignment.blackbox.mockito;

import org.mockito.Mockito;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> mock = Mockito.mock(List.class);
        Object o = new Object();
        mock.add(o);
        Mockito.verify(mock).add(o);
    }
}
