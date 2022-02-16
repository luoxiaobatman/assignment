package com.luoxiaobatman.assignment.support;

import com.luoxiaobatman.assignment.util.Iterables;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SolutionArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<SolutionSource> {
    private String[] strings;
    private String delimiter;
    private ArgumentsParser<?>[] argumentsParsers;

    private static final Map<Class<?>, ArgumentsParser<?>> map = new HashMap<>();
    static {
        register(Integer.class, new IntArgumentsParser());
        register(Integer[].class, new IntegersArgumentsParser(","));
        register(int[].class, new IntsArgumentsParser(","));
        register(String[].class, new StringsArgumentsParser(","));
        register(String.class, new NoopArgumentsParser(","));
        register(int[][].class, new IntssArgumentsParser(",", "|"));
        register(List.class, new ListOfListIntegerArgumentParser(",", "|"));
    }

    static<E> void register(Class<E> subject, ArgumentsParser<E> parser) {
        ArgumentsParser<?> old = map.putIfAbsent(subject, parser);
        if (old != null) {
            // TODO luoxiao
            throw new RuntimeException();
        }
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        Method method = context.getTestMethod().get();
        int chunkSize = method.getParameterCount();

        ArgumentsParser<?>[] argumentsParsers = this.argumentsParsers;
        if (argumentsParsers == null) {
            List<ArgumentsParser<?>> parserList = new ArrayList<>();
            for (Class<?> type : method.getParameterTypes()) {
                ArgumentsParser<?> parser = map.get(type);
                if (parser == null) {
                    // TODO luoxiao
                    throw new RuntimeException();
                }
                parserList.add(parser);
            }
            argumentsParsers = parserList.toArray(new ArgumentsParser[0]);

        }
        List<Object[]> chunks = Iterables.partition(strings, argumentsParsers, chunkSize);
        return Stream.of(
                chunks.stream().map(Arguments::of).toArray(Arguments[]::new)
        );
    }

    @Override
    public void accept(SolutionSource solutionSource) {
        this.delimiter = solutionSource.delimiter();
        Class<? extends ArgumentsParser<?>>[] classes = solutionSource.argumentsParsers();
        this.strings = solutionSource.value();
        if (classes.length > 0) {
            argumentsParsers = Arrays.stream(classes)
                    .map(c -> Factory.of(ArgumentsParser.class).newInstance(c, delimiter))
                    .toArray(ArgumentsParser[]::new);
        }
    }
}
