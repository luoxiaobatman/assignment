package com.luoxiaobatman.assignment.leetcode.dynamic;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * dp[i]表示放置前i本书所需的书架的最小高度
 * <p>
 * 状态转移方程有点迷, 出发点是最后一层尽可能填满, 去找dp[i]最小值
 *
 * <a href="https://leetcode-cn.com/problems/filling-bookcase-shelves/">填充书架</a>
 */
@AllArgsConstructor
public class P1105MediumOP
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[][] book;
    private final int shelfWidth;

    @Override
    public Integer doSolve() {
        return minHeightShelves(book, shelfWidth);
    }

    /**
     * TODO luoxiao 数学归纳证明状态转移方程的正确性
     */
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];
        Arrays.fill(dp, 1000 * 1000);

        // dp[i] 是放满i本书所需的书架的最小高度
        dp[0] = 0;
        // book[i] 第i本书, 从0开始
        for (int i = 0; i < books.length; i++) {
            int h = 0;
            int width = 0;
            // i(包括i)前面一共有j本书
            // 不断把上一层的书往下挪, 总是保持最后一层的书放满
            for (int j = i + 1; j > 0; j--) {
                width += books[j - 1][0];
                if (width > shelfWidth) break;
                h = Math.max(h, books[j - 1][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j - 1] + h);
            }
        }
        return dp[dp.length - 1];
    }
}
