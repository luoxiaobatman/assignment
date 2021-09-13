package com.luoxiaobatman.assignment.leetcode.trivial;

import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import com.luoxiaobatman.assignment.support.IntSortAlgArgumentProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class SortTest {

    @ParameterizedTest(name = ParameterizedTest.INDEX_PLACEHOLDER)
    @ArgumentsSource(IntSortAlgArgumentProvider.class)
    void testBubbleSort(int[] source, int[] expected) {
        Solution solution = Factory.of(Solution.class).newInstance(BubbleSort.class, source);
        int[] answer = (int[]) solution.solve().getAnswer();
        Assertions.assertArrayEquals(expected, answer);
    }

    @ParameterizedTest(name = ParameterizedTest.INDEX_PLACEHOLDER)
    @ArgumentsSource(IntSortAlgArgumentProvider.class)
    void testSelectSort(int[] source, int[] expected) {
        Solution solution = Factory.of(Solution.class).newInstance(SelectSort.class, source);
        int[] answer = (int[]) solution.solve().getAnswer();
        Assertions.assertArrayEquals(expected, answer);
    }

    @ParameterizedTest(name = ParameterizedTest.INDEX_PLACEHOLDER)
    @ArgumentsSource(IntSortAlgArgumentProvider.class)
    void testInsertionSort(int[] source, int[] expected) {
        Solution solution = Factory.of(Solution.class).newInstance(InsertionSort.class, source);
        int[] answer = (int[]) solution.solve().getAnswer();
        Assertions.assertArrayEquals(expected, answer);
    }

    @ParameterizedTest(name = ParameterizedTest.INDEX_PLACEHOLDER)
    @ArgumentsSource(IntSortAlgArgumentProvider.class)
    void testMergeSort(int[] source, int[] expected) {
        Solution solution = Factory.of(Solution.class).newInstance(MergeSort.class, source);
        int[] answer = (int[]) solution.solve().getAnswer();
        Assertions.assertArrayEquals(expected, answer);
    }

    @ParameterizedTest(name = ParameterizedTest.INDEX_PLACEHOLDER)
    @ArgumentsSource(IntSortAlgArgumentProvider.class)
    void testQuickSort(int[] source, int[] expected) {
        Solution solution = Factory.of(Solution.class).newInstance(QuickSort.class, source);
        int[] answer = (int[]) solution.solve().getAnswer();
        Assertions.assertArrayEquals(expected, answer);
    }

    @ParameterizedTest(name = ParameterizedTest.INDEX_PLACEHOLDER)
    @ArgumentsSource(IntSortAlgArgumentProvider.class)
    void testHeapSort(int[] source, int[] expected) {
        Solution solution = Factory.of(Solution.class).newInstance(HeapSort.class, source);
        int[] answer = (int[]) solution.solve().getAnswer();
        Assertions.assertArrayEquals(expected, answer);
    }
}
