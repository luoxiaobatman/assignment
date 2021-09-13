package com.luoxiaobatman.assignment.leetcode.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 回文
 */
public class PalindromeProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Arrays.stream(new Arguments[] {
                Arguments.of("a", "a"),
                Arguments.of("abba", "abba"),
                Arguments.of("fddsa", "dd"),
                Arguments.of("0110accca12", "accca"),
        });
    }
}
