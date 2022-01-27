package com.luoxiaobatman.assignment.jdk.time;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

@AllArgsConstructor
public class ChineseStyleTimeParseExp extends AbstractSolution<TemporalAccessor> implements GenericSolution<TemporalAccessor> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(
            "yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

    private final String timeLiteral;

    @Override
    public TemporalAccessor doSolve() {
        return FORMATTER.parse(timeLiteral);
    }
}
