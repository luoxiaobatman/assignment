package com.luoxiaobatman.assignment.support;

public class NoopArgumentsParser implements ArgumentsParser<String> {
    @Override
    public String parse(String argument) {
        return argument;
    }
}
