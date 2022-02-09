package com.luoxiaobatman.assignment.support;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

@AllArgsConstructor
public class IntsArgumentsParser implements ArgumentsParser<int[]>{
//    static {
//        SolutionArgumentsProvider.register(int[].class, new IntsArgumentsParser(","));
//    }

    private final String delimiter;

    @Override
    public int[] parse(String argument) {
        if ("".equals(argument)) {
            return new int[0];
        }

        String[] splitArguments = argument.split(delimiter);

        int[] result = new int[splitArguments.length];
        for (int i = 0; i < splitArguments.length; i++) {
            result[i] = Integer.parseInt(splitArguments[i]);
        }
        return result;
    }
}
