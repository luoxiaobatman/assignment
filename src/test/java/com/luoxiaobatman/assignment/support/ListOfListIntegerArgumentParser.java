package com.luoxiaobatman.assignment.support;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ListOfListIntegerArgumentParser implements ArgumentsParser<List> {
    private final String delimiter;
    private final String secondDimensionDelimiter;

    @Override
    public List parse(String argument) {
        List<List<Integer>> result = new ArrayList<>();
        for (String secondDimensionDelimiterSplitRawString : argument.split(delimiter)) {
            List<Integer> secondDimension = new ArrayList<>();
            result.add(secondDimension);
            for (String integerString : secondDimensionDelimiterSplitRawString.split("\\|")) {
                secondDimension.add(Integer.parseInt(integerString));
            }
        }

        return result;
    }
}
