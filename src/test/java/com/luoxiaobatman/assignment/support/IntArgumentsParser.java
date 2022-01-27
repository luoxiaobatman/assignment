package com.luoxiaobatman.assignment.support;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

@AllArgsConstructor
public class IntArgumentsParser implements ArgumentsParser<Integer>{
    /**
     * eh...
     */
    private String delimiter;

    @Override
    public Integer parse(String argument) {
        return Integer.parseInt(argument);
    }
}
