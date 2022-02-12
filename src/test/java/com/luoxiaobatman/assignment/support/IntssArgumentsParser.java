package com.luoxiaobatman.assignment.support;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class IntssArgumentsParser implements ArgumentsParser<int[][]> {
    private final String delimiter;
    private final String secondDimensionDelimiter;

    @Override
    public int[][] parse(String argument) {
        if ("".equals(argument)) {
            return new int[0][];
        }

        String[] splitArguments = argument.split(delimiter);

        int[][] result = new int[splitArguments.length][];
        for (int i = 0; i < splitArguments.length; i++) {
            Integer[] tmp = Arrays.stream(splitArguments[i].split("\\|"))
                    .map(Integer::parseInt).toArray(Integer[]::new);
            result[i] = new int[tmp.length];
            for (int j = 0; j < tmp.length; j++) {
                result[i][j] = tmp[j];
            }
        }
        return result;
    }
}
