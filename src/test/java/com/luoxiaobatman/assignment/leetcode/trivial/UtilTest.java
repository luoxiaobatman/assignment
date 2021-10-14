package com.luoxiaobatman.assignment.leetcode.trivial;

import com.luoxiaobatman.assignment.leetcode.provider.SubsetSumProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class UtilTest {

    @ParameterizedTest(name = ParameterizedTest.INDEX_PLACEHOLDER)
    @ArgumentsSource(SubsetSumProvider.class)
    void testSubsetSum(int[] source, int[] expected) {
        Assertions.assertArrayEquals(expected, Util.subsetSum(source));
    }
}
