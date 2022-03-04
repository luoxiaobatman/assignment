package com.luoxiaobatman.assignment.support;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NoopArgumentsParser implements ArgumentsParser<String> {
    private String delimiter;

    @Override
    public String parse(String argument) {
        if ("NULL".equals(argument)) {
            return null;
        }
        return argument;
    }
}
