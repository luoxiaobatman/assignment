package com.luoxiaobatman.assignment.jdk.time;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

@AllArgsConstructor
public class ChineseStyleTimeFormatExp extends AbstractSolution<String> implements GenericSolution<String> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(
            "yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

    private final TemporalAccessor accessor;

    @Override
    public String doSolve() {
        return FORMATTER.format(accessor);
    }
}
