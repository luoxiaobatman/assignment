package com.luoxiaobatman.assignment.ant;


import com.luoxiaobatman.assignment.ant.provider.argument.AggUnorderdStringArgumentProvider;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collection;
import java.util.List;
import java.util.Queue;

public class AggUnorderedStringTest {
    /**
     * 黑盒测试, TODO, 检查return value
     * @param strings 原始
     * @param reporter 报告
     */
    @ParameterizedTest(name = ParameterizedTest.INDEX_PLACEHOLDER )
    @ArgumentsSource(AggUnorderdStringArgumentProvider.class)
    public void solveTest(List<String> strings, TestReporter reporter) {
        Factory<Solution> solutionFactory = Factory.of(Solution.class);
        Solution solution = solutionFactory.newInstance(AggUnorderedString.class);
        Object solve = solution.solve();
        reporter.publishEntry("problem", strings.toString());
        reporter.publishEntry("result", solve.toString());
    }

    /**
     * 提供多种实现, 记录耗时, 输出表格
     */
    public void timed() {

    }
}
