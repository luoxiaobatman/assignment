package com.luoxiaobatman.assignment.leetcode.foryou;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * <p>
 * 方法1:
 * 动态规划算法 dp 是一个二维数组, 即 dp[][]
 * 状态迁移方程: dp[n] = forall dp[n - 1] + forall elements left,
 * 时间复杂度 < O(MIN(C(N/2, N), M * N) * N^2)
 *
 * score=10 (困难10)
 * <p>
 * 进阶: NO
 * <p>
 * 给定的整数数组 A ，我们要将 A数组 中的每个元素移动到 B数组 或者 C数组中。（B数组和C数组在开始的时候都为空）
 * 返回true ，当且仅当在我们的完成这样的移动后，可使得B数组的平均值和C数组的平均值相等，并且B数组和C数组都不为空。
 * <p>
 * A 数组的长度范围为 [1, 30].
 * <p>
 * A[i] 的数据范围为 [0, 10000].
 */
public class P805 {
//    private List<List<Integer>> intss;
//    private final AtomicInteger state = new AtomicInteger();
//    private final ExecutorService executorService = Executors.newFixedThreadPool(8);
//    private AtomicIntegerArray visitedRooms;
//
//    public P841(List<List<Integer>> intss) {
//        this.intss = intss;
//        visitedRooms = new AtomicIntegerArray(intss.size());
//        state.set(intss.size());
//    }
//
//    @Override
//    public Answer solve() {
//        Answer answer = Factory.of(Answer.class).newInstance();
//        answer.setAnswer(false);
//        List<Integer> keys = intss.get(0);
//        visitRooms(keys);
//        try {
//            executorService.shutdown();
//            // TODO solve 超时
//            boolean b = executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            return answer;
//        }
//        answer.setAnswer(state.get() == 0);
//        return answer;
//    }
}
