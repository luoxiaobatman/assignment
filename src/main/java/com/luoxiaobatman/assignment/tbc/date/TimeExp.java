package com.luoxiaobatman.assignment.tbc.date;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import com.luoxiaobatman.assignment.support.solution.Solver;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

/**
 * Instant – represents a point in time (timestamp)
 * LocalDate – represents a date (year, month, day)
 * LocalDateTime – same as LocalDate, but includes time with nanosecond precision
 * OffsetDateTime – same as LocalDateTime, but with time zone offset
 * LocalTime – time with nanosecond precision and without date information
 * ZonedDateTime – same as OffsetDateTime, but includes a time zone ID
 * OffsetLocalTime – same as LocalTime, but with time zone offset
 * MonthDay – month and day, without year or time
 * YearMonth – month and year, without day or time
 * Duration – amount of time represented in seconds, minutes and hours. Has nanosecond precision
 * Period – amount of time represented in days, months and years
 */
public class TimeExp extends AbstractSolution<Object> implements GenericSolution<Object> {
    @Override
    public Object doSolve() {
        Instant now = Instant.now();
        now.getEpochSecond();
        SimpleDateFormat formatter = new SimpleDateFormat("LLL");
        System.out.println(formatter.format(new Date()));
        return null;
    }

    public static void main(String[] args) {
        Solver.solve(TimeExp.class);
    }
}
