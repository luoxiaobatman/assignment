package com.luoxiaobatman.assignment.util;

import com.luoxiaobatman.assignment.support.ArgumentsParser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Iterables {
    public static List<Object[]> partition(Object[] objects, ArgumentsParser<?>[] argumentsParsers, int chunkSize) {
        assert chunkSize == argumentsParsers.length;
        return IntStream.range(0, objects.length / chunkSize)
                .mapToObj(i -> {
                    Object[] result = new Object[chunkSize];
                    for (int j = 0; j < chunkSize; j++) {
                        result[j] = argumentsParsers[j].parse((String) objects[i * chunkSize + j]);
                    }
                    return result;
                })
                .collect(Collectors.toList());
    }
}
