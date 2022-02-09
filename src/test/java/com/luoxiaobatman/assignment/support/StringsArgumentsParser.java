package com.luoxiaobatman.assignment.support;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StringsArgumentsParser implements ArgumentsParser<String[]>{
//    static {
//        SolutionArgumentsProvider.register(String[].class, new StringsArgumentsParser(","));
//    }

    private final String delimiter;

    @Override
    public String[] parse(String argument) {
        if ("".equals(argument)) {
            return new String[0];
        }

        return argument.split(delimiter);
    }
}
