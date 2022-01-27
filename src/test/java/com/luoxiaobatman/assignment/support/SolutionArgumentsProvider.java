package com.luoxiaobatman.assignment.support;

import com.luoxiaobatman.assignment.util.Iterables;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SolutionArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<SolutionSource> {
    private String[] strings;
    private String delimiter;
    private ArgumentsParser<?>[] argumentsParsers;
    private int argumentsCount;

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        List<Object[]> chunks = Iterables.partition(strings, argumentsParsers, argumentsCount);
        return Stream.of(
                chunks.stream().map(Arguments::of).toArray(Arguments[]::new)
        );
    }

    @Override
    public void accept(SolutionSource solutionSource) {
        this.delimiter = solutionSource.delimiter();
        this.argumentsCount = solutionSource.argumentsCount();
        this.strings = solutionSource.value();
        Class<? extends ArgumentsParser<?>>[] classes = solutionSource.argumentsParsers();
        if (classes.length == 0) {
            argumentsParsers = new ArgumentsParser[argumentsCount];
            Arrays.fill(argumentsParsers, Factory.of(ArgumentsParser.class).newInstance(
                    solutionSource.argumentParser(), delimiter
            ));
            return;
        }
        assert classes.length == argumentsCount;
        argumentsParsers = Arrays.stream(classes)
                .map(c -> Factory.of(ArgumentsParser.class).newInstance(c, delimiter))
                .toArray(ArgumentsParser[]::new);
    }
}
