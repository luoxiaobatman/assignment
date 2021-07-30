package com.luoxiaobatman.assignment.ant;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import net.jmatrix.console.log.ColorConsoleLogger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.platform.commons.logging.LoggerFactory;
import org.slf4j.event.Level;

import java.beans.BeanProperty;

/**
 * end with test not start with
 * same package, to access protected
 */
@Slf4j
public class AggUnorderedStringTest {
//    @ParameterizedTest
//    @ArgumentsSource(MyArgumentsProvider.class)
    @TestFactory
    public void solveTest(String foo) {
        return DynamicNode
        log.info(foo);
    }

    @BeforeAll
    public static void beforeAll() {
        ColorConsoleLogger.setGlobalLevel(Level.INFO);
    }

    @AfterAll
    public static void afterAll() {
    }
}
