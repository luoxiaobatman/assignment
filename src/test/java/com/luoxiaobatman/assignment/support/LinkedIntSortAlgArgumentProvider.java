package com.luoxiaobatman.assignment.support;

import lombok.Data;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 整型数组排序算法参数 provider
 */
public class LinkedIntSortAlgArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Arrays.stream(new Arguments[] {
                Arguments.of(new int[] {3, 2, 1}, new int[] {1, 2, 3}),
                Arguments.of(new int[] {0}, new int[] {0}),
                Arguments.of(new int[] {7, 2, 2, 0, 0}, new int[] {0, 0, 2, 2, 7}),
                Arguments.of(new int[] {1, -1}, new int[] {-1, 1}),
                Arguments.of(new int[] {1, 2, 1, -1, -1, 0}, new int[] {-1, -1, 0, 1, 1, 2})
        });
    }
}
