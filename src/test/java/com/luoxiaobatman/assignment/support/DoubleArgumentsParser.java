package com.luoxiaobatman.assignment.support;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DoubleArgumentsParser implements ArgumentsParser<Double>{
    @Override
    public Double parse(String argument) {
        return Double.parseDouble(argument);
    }
}
