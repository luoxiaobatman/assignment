package com.luoxiaobatman.assignment.ant.provider.argument;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AggUnorderdStringArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        List<String> strings = Arrays.asList("foo", "bar", "baz", "oof", "", "ccc", null);
        return Arrays.stream(new List[]{strings}).map(Arguments::of);
    }
}
