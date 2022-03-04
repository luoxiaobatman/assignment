package com.luoxiaobatman.assignment.interview.coding.bigai;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * 不用临时变量交换数字
 */
@AllArgsConstructor
public class SwitchInteger
        extends AbstractSolution<int[]> implements GenericSolution<int[]> {
    /**
     * length=2
     */
    private final int[] sources;

    /**
     * xor
     * 1 1 0 1 1  a
     * 0 0 0 0 1  b
     *
     * 1 1 0 1 0  目标
     *
     * 1 1 0 1 1  |   x
     * 0 0 0 0 1  &   y
     * x - y = z
     *
     *
     * 13 4
     * 1 1 0 1
     * 0 1 0 0
     *
     * 1 1 0 1
     * 0 1 0 0
     *
     * 1 0 0 1
     *
     *
     * 1 0 1     5
     * 0 0 1     1
     *
     * 1 0 1     5
     * 1 0 0     4  (5 异或 1)
     *
     * 0 0 1     1  (5 异或 4 得到 1)
     * 1 0 0     4
     *
     * 0 0 1     1
     * 1 0 1     5  (1 异或 4  得到5)
     *
     *
     *
     * 7 8
     * 0 1 1 1     7
     * 1 0 0 0     8
     *
     * 0 1 1 1
     * 1 1 1 1    异或
     *
     * 1 0 0 0    异或
     * 1 1 1 1
     *
     * 1 0 0 0
     * 0 1 1 1    异或
     *
     *
     * 13 3
     * 8 + 4 + 1
     * 1 1 0 1    13
     * 0 0 1 1    3
     *
     * 1 1 0 1
     * 1 1 1 0
     *
     * 0 0 1 1
     * 1 1 1 0
     *
     * 0 0 1 1
     * 1 1 0 1
     */
    @Override
    public int[] doSolve() {
        int[] tmp = Arrays.copyOf(sources, sources.length);
        tmp[1] = xor(tmp);
        tmp[0] = xor(tmp);
        tmp[1] = xor(tmp);
        return tmp;
    }

    private int xor(int[] operands) {
        return (operands[0] | operands[1]) - (operands[0] & operands[1]);
    }
}
