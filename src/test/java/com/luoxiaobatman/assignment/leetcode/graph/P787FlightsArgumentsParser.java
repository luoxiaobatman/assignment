package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.support.ArgumentsParser;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class P787FlightsArgumentsParser implements ArgumentsParser<int[][]> {
    private final String delimiter;

    @Override
    public int[][] parse(String argument) {
        String[] split = argument.split(delimiter);
        int[][] result = new int[split.length][];
        for (int i = 0; i < split.length; i++) {
            result[i] = new int[3];
            String[] split1 = split[i].split("\\.");
            for (int j = 0; j < 3; j++) {
                result[i][j] = Integer.parseInt(split1[j]);
            }
        }
        return result;
    }
}
