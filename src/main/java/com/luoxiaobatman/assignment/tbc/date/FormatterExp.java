package com.luoxiaobatman.assignment.tbc.date;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import com.luoxiaobatman.assignment.support.solution.Solver;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class FormatterExp extends AbstractSolution<Long> implements GenericSolution<Long> {
    @Override
    public Long doSolve() {
        SimpleDateFormat formatter = new SimpleDateFormat();
        DateTimeFormatter.ISO_DATE.format(Year.now());
        return null;
    }

    public static void main(String[] args) {
        Solver.solve(FormatterExp.class);
    }
}
