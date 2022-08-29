package com.luoxiaobatman.assignment.interview.coding.nh.nbag;

import java.util.*;

/**
 * 记得是个dp问题
 * 思路:
 * dp[i][j]
 * iMax=盒子的最大重量
 * j是否选择标号为j的物品
 * 基本的状态转移方程, 省略特殊
 * dp[i] = max(dp[i - k] + things[k].value)
 */
public class Solution {
	/**
	 * nbag问题解
	 * dp[boxMaxWeight][things.size()]
	 * nbag 20的解
	 * dp[19][19]
	 *
	 * @param boxMaxWeight 箱子重量
	 * @param things 下标物品编号, 值是(weight, value)二元组
	 * @return 选择的物品
	 */
	private int[] nbag(int boxMaxWeight, int[][] things) {
		int[][] dp = new int[boxMaxWeight + 1][things.length + 1];
		dp[0] = new int[things.length + 1];
		for (int i = 1; i < boxMaxWeight + 1; i++) {
			int maxValue = 0;
			for (int j = 0; j < things.length; j++) {
				int weight = things[j][0];
				int value = things[j][1];
				int lastDpIndex = i - weight;
				if (lastDpIndex >= 0) {
					int[] lastDp = dp[lastDpIndex];
					if (lastDp[j] == 0) {
						int nextMaxValue = lastDp[things.length] + value;
						if (maxValue < nextMaxValue) {
							maxValue = nextMaxValue;
							dp[i] = Arrays.copyOf(lastDp, lastDp.length);
							dp[i][j] = 1;
							dp[i][things.length] = maxValue;
						}
					}
				}
			}
		}
		return dp[boxMaxWeight];
	}

	public static void main(String[] args) {
		int[][] things = new int[][] {
				{3, 4},
				{4, 6},
				{2, 3},
				{5, 8},
				{8, 13},
				{7, 12},
				{5, 11},
		};
		int boxMaxWeight = 20;
		Solution solution = new Solution();
		int[] nbag = solution.nbag(boxMaxWeight, things);
		System.out.println(Arrays.toString(nbag));
	}
}
