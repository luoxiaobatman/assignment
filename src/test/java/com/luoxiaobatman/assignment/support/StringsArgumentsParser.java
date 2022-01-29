package com.luoxiaobatman.assignment.support;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StringsArgumentsParser implements ArgumentsParser<String[]>{
    private String delimiter;

    @Override
    public String[] parse(String argument) {
        return argument.split(delimiter);
    }
}
