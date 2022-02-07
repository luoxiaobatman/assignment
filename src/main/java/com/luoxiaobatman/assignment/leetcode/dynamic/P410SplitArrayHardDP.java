package com.luoxiaobatman.assignment.leetcode.dynamic;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * <pre>
 * 动态规划
 * dp[n][m], n<=N, m<=k
 * dp[i][j] 为前i个元素被分成j段的 所求值 dp[N][k] 为所求结果
 * 令dp[0][0] = 0, 其余为Integer.MAX_VALUE
 * 状态转移方程为 dp[i][j] = 遍历s:min(dp[i-s][j-1], sum(arr,i-s,i))
 * </pre>
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 * <p>
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。
 * 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5], m = 2
 * 输出：9
 * 示例 3：
 * <p>
 * 输入：nums = [1,4,4], m = 3
 * 输出：4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 106
 * 1 <= m <= min(50, nums.length)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@AllArgsConstructor
public class P410SplitArrayHardDP extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[] arr;
    private final int k;

    @Override
    public Integer doSolve() {
        return splitArray(arr, k);
    }

    // ============= leetcode ============

    public int splitArray(int[] nums, int m) {
        // i j, 从第i个开始, 到第j个的和.
        int[][] sums = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = new int[nums.length];
            sums[i][i] = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sums[i][j] = sums[i][j - 1] + nums[j];
            }
        }

        int[][] dp = new int[nums.length + 1][];
        // i 包含 i个前缀
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i] = new int[m + 1];
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            if (i > 0) {
                dp[i][1] = sums[0][i - 1];
            }
        }

        for (int i = 1; i < nums.length + 1; i++) {
            int k = Math.min(i + 1, m + 1);
            for (int j = 2; j < k; j++) {
                for (int s = j - 1; s < i; s++) {
                    dp[i][j] = Math.min(Math.max(sums[s][i - 1], dp[s][j - 1]), dp[i][j]);
                }
            }
        }
        return dp[nums.length][m];
    }
}
