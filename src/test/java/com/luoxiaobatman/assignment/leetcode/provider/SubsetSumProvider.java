package com.luoxiaobatman.assignment.leetcode.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 子集和
 * 顺序按照自然数增需, 下标比特位
 */
public class SubsetSumProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Arrays.stream(new Arguments[] {
                Arguments.of(new int[]{}, new int[] {0}),
                Arguments.of(new int[]{1}, new int[]{0, 1}),
                Arguments.of(new int[]{-1}, new int[]{0, -1}),
                Arguments.of(new int[]{-1, 1}, new int[]{0, -1, 1, 0}),
        });
    }
}
