package com.luoxiaobatman.assignment.support;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

@AllArgsConstructor
public class IntArgumentsParser implements ArgumentsParser<Integer>{
//    static {
//        SolutionArgumentsProvider.register(Integer.class, new IntArgumentsParser());
//    }

    @Override
    public Integer parse(String argument) {
        return Integer.parseInt(argument);
    }
}
