package com.luoxiaobatman.assignment.jdk.time;

import com.luoxiaobatman.assignment.support.solution.Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class TimeExpTest {
    @ParameterizedTest
    @ValueSource(strings = {"2021-01-01 10:00:00"})
    public void parseTest(String literal) {
        TemporalAccessor answer = Solver.solve(ChineseStyleTimeParseExp.class, literal);
        Assertions.assertEquals(answer.get(ChronoField.DAY_OF_MONTH), 1);
        Assertions.assertEquals(answer.get(ChronoField.HOUR_OF_DAY), 10);
    }

    @Test
    public void formatTest() {
        Assertions.assertDoesNotThrow(() -> {
            LocalDateTime now = LocalDateTime.now();
            Solver.solve(ChineseStyleTimeFormatExp.class, now);
        });
    }
}
