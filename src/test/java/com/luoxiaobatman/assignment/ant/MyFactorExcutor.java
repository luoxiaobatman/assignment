package com.luoxiaobatman.assignment.ant;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.function.Executable;

@Slf4j
public class MyFactorExcutor implements Executable {
    @Override
    public void execute() throws Throwable {
        log.warn("execute");
    }
}
