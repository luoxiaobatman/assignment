package com.luoxiaobatman.assignment.interview.coding.huawei.spring2022;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二维数组
 * <p>
 * 每个元素是一个int, 表示砖块的宽度, 低维数组的一行砖块垒成一行, 高维数组从上到下垒成一列
 * <p>
 * 要求线从缝隙中穿过上到下穿过, 穿过的缝隙最少
 */
@AllArgsConstructor
public class MinimumBreak
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final List<List<Integer>> breakss;

    @Override
    public Integer doSolve() {
        // key表示的缝隙的位置, value表示在这个位置缝隙有多少个
        Map<Integer, Integer> splitMap = new HashMap<>();

        for (List<Integer> breaks : breakss) {
            int currentLength = 0;
            for (int i = 0; i < breaks.size() - 1; i++) {
                Integer aBreak = breaks.get(0);
                currentLength += aBreak;
                Integer splitCount = splitMap.getOrDefault(currentLength, 0);
                splitMap.put(currentLength, splitCount + 1);
            }
        }
        // 遍历splitMap, 找到value值最大的一个返回
        int maxSplit = 0;
        for (Integer splitCount : splitMap.values()) {
            maxSplit = Math.max(maxSplit, splitCount);
        }
        return breakss.size() - maxSplit;
    }
}
