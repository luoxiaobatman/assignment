package com.luoxiaobatman.assignment.support;


import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(SolutionArgumentsProvider.class)
public @interface SolutionSource {
    String[] value();
    int argumentsCount() default 1;
    Class<? extends ArgumentsParser<?>>[] argumentsParsers() default {};
    Class<? extends ArgumentsParser<?>> argumentParser() default NoopArgumentsParser.class;
    String delimiter() default "";
}
