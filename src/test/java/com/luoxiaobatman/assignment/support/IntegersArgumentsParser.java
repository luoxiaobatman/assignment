package com.luoxiaobatman.assignment.support;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IntegersArgumentsParser implements ArgumentsParser<Integer[]>{
    private final String delimiter;

    @Override
    public Integer[] parse(String argument) {
        String[] splitArguments = argument.split(delimiter);

        Integer[] result = new Integer[splitArguments.length];
        for (int i = 0; i < splitArguments.length; i++) {
            if ("null".equals(splitArguments[i])) {
                result[i] = null;
            } else {
                result[i] = Integer.parseInt(splitArguments[i]);
            }
        }
        return result;
    }
}
