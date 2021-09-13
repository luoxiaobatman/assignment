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
 * score=6 (基础1 + 5多线程)
 * <p>
 * 进阶: score 10 AtomicIntegerArray 设计与实现
 * <p>
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * 你可以自由地在房间之间来回走动。
 * <p>
 * 如果能进入每个房间返回 true，否则返回 false。
 */
public class P841 implements Solution {
    private List<List<Integer>> intss;
    private final AtomicInteger state = new AtomicInteger();
    private final ExecutorService executorService = Executors.newFixedThreadPool(8);
    private AtomicIntegerArray visitedRooms;

    public P841(List<List<Integer>> intss) {
        this.intss = intss;
        visitedRooms = new AtomicIntegerArray(intss.size());
        state.set(intss.size());
    }

    @Override
    public Answer solve() {
        Answer answer = Factory.of(Answer.class).newInstance();
        answer.setAnswer(false);
        List<Integer> keys = intss.get(0);
        visitRooms(keys);
        try {
            executorService.shutdown();
            // TODO solve 超时
            boolean b = executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            return answer;
        }
        answer.setAnswer(state.get() == 0);
        return answer;
    }

    private void visitRooms(List<Integer> keys) {
        for (Integer nextKey : keys) {
            executorService.submit(() -> {
                visitRoom(nextKey);
            });
        }
    }

    private void visitRoom(Integer key) {
        boolean notVisited = visitedRooms.compareAndSet(key, 0, 1);
        if (notVisited) {
            state.decrementAndGet();
            visitRooms(intss.get(key));
        }
    }
}
