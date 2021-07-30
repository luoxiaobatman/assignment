package com.luoxiaobatman.assignment.ant;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class MyArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Arrays.stream(new String[]{"foo", "bar"}).map(Arguments::of);
    }
}
