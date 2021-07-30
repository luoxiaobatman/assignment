package com.luoxiaobatman.assignment.ant;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import net.jmatrix.console.log.ColorConsoleLogger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.platform.commons.logging.LoggerFactory;
import org.slf4j.event.Level;

import java.beans.BeanProperty;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * end with test not start with
 * same package, to access protected
 */
@Slf4j
public class AggUnorderedStringTest {
//    @ParameterizedTest
//    @ArgumentsSource(MyArgumentsProvider.class)
    @TestFactory
    public DynamicNode[] solveTest(String foo) {
        ParameterResolver
        DynamicTest dynamicTest = DynamicTest.dynamicTest("name-foo", new MyFactorExcutor());
        return new DynamicNode[] {dynamicTest, dynamicTest};
    }

    @BeforeAll
    public static void beforeAll() {
        ColorConsoleLogger.setGlobalLevel(Level.INFO);
    }

    @AfterAll
    public static void afterAll() {
    }
}
