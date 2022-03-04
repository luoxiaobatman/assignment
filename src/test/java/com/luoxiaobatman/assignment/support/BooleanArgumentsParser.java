package com.luoxiaobatman.assignment.support;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BooleanArgumentsParser implements ArgumentsParser<Boolean>{
    @Override
    public Boolean parse(String argument) {
        if (argument.equals("true")) return true;
        return false;
    }
}
