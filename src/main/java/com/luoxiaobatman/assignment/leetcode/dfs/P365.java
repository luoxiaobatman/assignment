package com.luoxiaobatman.assignment.leetcode.dfs;

import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 状态记忆
 * 深度优先搜索树
 * 树的分叉一共有
 * 1. 将x倒掉
 * 2. 将x倒进y
 * 3. 将x装满
 * 4. 将y倒掉
 * 5. 将y倒进x
 * 6. 将y装满
 * 用一个set来存储已经访问过的状态
 * 状态用 (x里面的水, y里面水) 二元组表示
 * 到搜索到z的时候, 直接返回true
 * 搜索完毕返回false
 *
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？

如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。

你允许：

装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空
 */
@AllArgsConstructor
public class P365 implements Solution {
    private final int x;
    private final int y;
    private final int z;
    @Override
    public Answer solve() {
        Set<String> visited = new HashSet<>();
        visited.add("0_0");
        State state0 = new State(0, 0);
//        if (pourX())

        return null;
    }

    @AllArgsConstructor
    private static class State {
        public int xV;
        public int yV;

        @Override
        public String toString() {
            return "State{" +
                    "xV=" + xV +
                    ", yV=" + yV +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return xV == state.xV && yV == state.yV;
        }

        @Override
        public int hashCode() {
            return Objects.hash(xV, yV);
        }
    }

    private State fillX(State prev, Set<String> set, int z) {
        return new State(x, prev.yV);
    }
    private State pourXIntoY(State prev) {
        int delta = y - prev.yV;
        // 倒完
        if (delta > prev.xV) {
            return new State(0, prev.xV + prev.yV);
        } else {
            return new State(prev.xV - delta, y);
        }
    }
    private State pourX(State prev) {
        return new State(0, prev.yV);
    }

    private State fillY(State prev) {
        return new State(prev.xV, y);
    }
    private State pourYIntoX(State prev) {
        int delta = x - prev.xV;
        // 倒完
        if (delta > prev.yV) {
            return new State(prev.xV + prev.yV, 0);
        } else {
            return new State(x,prev.yV - delta);
        }
    }
    private State pourY(State prev) {
        return new State(prev.xV, 0);
    }

    @Override
    public String toString() {
        return "P365{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
