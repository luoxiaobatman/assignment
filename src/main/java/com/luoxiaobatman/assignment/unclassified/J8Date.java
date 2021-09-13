package com.luoxiaobatman.assignment.unclassified;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class J8Date {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2021, 4, 2);
        date.plus(2, ChronoUnit.HOURS);
    }
}
