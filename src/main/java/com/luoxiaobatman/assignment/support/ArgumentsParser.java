package com.luoxiaobatman.assignment.support;

@Default(NoopArgumentsParser.class)
@Invoker
public interface ArgumentsParser<R> {
    R parse(String argument);
}
