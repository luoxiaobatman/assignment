package com.luoxiaobatman.assignment.interview.coding.huawei.spring2022;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述...
 */
@AllArgsConstructor
public class ChessBoardSimpleGo
        extends AbstractSolution<int[][]> implements GenericSolution<int[][]> {
    public static final int X = 0;
    public static final int O = 1;

    /**
     * 用0表示X, 用1表示O
     */
    private final int[][] board;

    /**
     * 从左到右
     * 从上到下
     *
     * 时间O(n*m)
     * 空间O(n*m)
     */
    @Override
    public int[][] doSolve() {
        // (i, j) 二元组 就是一个点
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            int[] line = board[i];
            for (int j = 0; j < line.length; j++) {
                // 找到了O
                if (board[i][j] == 1) {
                    if (isAdjacentByX(i, j)) {
                        int[] item = new int[2];
                        resultList.add(item);
                        item[0] = i;
                        item[1] = j;
                    }
                }
            }
        }
        int[][] result = new int[resultList.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private boolean isAdjacentByX(int k, int s) {
        // 周围是否均是X
        boolean flag = true;
        for (int i = -1; i < 2; i = i + 2) {
            try {
                flag = board[k + i][s] == X;
            } catch (IndexOutOfBoundsException ignored) {
            }
            if (!flag) {
                return false;
            }
        }
        for (int j = -1; j < 2; j = j + 2) {
            try {
                flag = board[k][s + j] == X;
            } catch (IndexOutOfBoundsException ignored) {
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
