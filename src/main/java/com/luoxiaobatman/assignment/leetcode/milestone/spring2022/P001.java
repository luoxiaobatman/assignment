package com.luoxiaobatman.assignment.leetcode.milestone.spring2022;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import com.luoxiaobatman.assignment.util.Bits;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class P001
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[] sources;

    @Override
    public Integer doSolve() {
//        return bit(sources);
        return moll(sources);
    }

    /**
     * 位运算, 观察int有32位
     * 做32次遍历, 找出每位的众数
     * @return 众数
     */
    private int bit(int[] sources) {
        int major = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            mask = mask << 1;
            int bitCount = 0;
            for (int j = 0; j < sources.length; j++) {
                if ((sources[j] & mask) == mask) {
                    bitCount++;
                    if (bitCount > sources.length / 2) {
                        major = major | mask;
                        break;
                    }
                }
            }
        }
        return major;
    }

    /**
     * 摩尔投票
     */
    private int moll(int[] sources) {
        int major = sources[0];
        int count = 1;
        for (int source : sources) {
            if (source == major) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    major = source;
                    count = 1;
                }
            }
        }
        return major;
    }
}
