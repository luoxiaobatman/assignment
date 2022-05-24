package com.luoxiaobatman.assignment.leetcode.dfs;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/water-and-jug-problem/">水壶问题</a>
 * <p>
 * stateInit -> stateA 倒满jugA
 * stateInit -> stateB 倒满jubB
 * stateInit -> stateC 从jubA往jubB倒 情况1, jubA将jubB倒满
 * stateInit -> stateD 从jubA往jubB倒 情况2, jubA不能将jubB倒满
 * stateInit -> stateE ...
 * stateInit -> stateF ...
 * stateInit -> stateG 倒光jubA
 * stateInit -> stateH 倒光jubB
 */
@AllArgsConstructor
public class P365 extends AbstractSolution<Boolean> implements GenericSolution<Boolean> {
    private final Integer jugACapacity;
    private final Integer jubBCapacity;
    private final Integer target;

    @Override
    public Boolean doSolve() {
        return canMeasureWater(jugACapacity, jubBCapacity, target);
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        State init = new State();
        Queue<State> waiting = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        waiting.offer(init);
        State next;
        StateTransfer transfer = new StateTransfer(jug1Capacity, jug2Capacity);
        while ((next = waiting.poll()) != null) {
            if (visited.contains(next)) continue;
            if (next.getContained() == targetCapacity)
                return true;
            // 4 parameters, TODO refactor to 3 or less
            transferInAStandardWay(next, transfer, visited, waiting);
            visited.add(next);
        }
        return false;
    }

    private void transferInAStandardWay(State state, StateTransfer transfer, Set<State> visited, Queue<State> waiting) {
        State pending;
        pending = transfer.fillA(state);
        if (!visited.contains(pending)) {
            waiting.offer(pending);
        }

        pending = transfer.fillB(state);
        if (!visited.contains(pending)) {
            waiting.offer(pending);
        }

        pending = transfer.clearA(state);
        if (!visited.contains(pending)) {
            waiting.offer(pending);
        }

        pending = transfer.clearB(state);
        if (!visited.contains(pending)) {
            waiting.offer(pending);
        }

        pending = transfer.pourA2B(state);
        if (!visited.contains(pending)) {
            waiting.offer(pending);
        }

        pending = transfer.pourB2A(state);
        if (!visited.contains(pending)) {
            waiting.offer(pending);
        }
    }

    private static class State {
        int jugAContained;
        int jugBContained;

        public State(int jugAContained, int jugBContained) {
            this.jugAContained = jugAContained;
            this.jugBContained = jugBContained;
        }

        private State() {
            this.jugAContained = 0;
            this.jugBContained = 0;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof State otherState) {
                return this.jugAContained == otherState.jugAContained
                        && this.jugBContained == otherState.jugBContained;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return jugAContained * 13 + jugBContained * 17;
        }

        public int getContained() {
            return jugBContained + jugAContained;
        }
    }

    /**
     * 状态迁移
     */
    private static class StateTransfer {
        private final int jugACapacity;
        private final int jugBCapacity;

        private final StateTransfer conjugated;

        public StateTransfer(int jugACapacity, int jugBCapacity) {
            this.jugACapacity = jugACapacity;
            this.jugBCapacity = jugBCapacity;
            conjugated = new StateTransfer(jugBCapacity, jugACapacity, this);
        }

        private StateTransfer(int jugACapacity, int jugBCapacity, StateTransfer conjugated) {
            this.jugACapacity = jugACapacity;
            this.jugBCapacity = jugBCapacity;
            this.conjugated = conjugated;
        }

        public State fillA(State state) {
            State next = new State();
            next.jugBContained = state.jugBContained;
            next.jugAContained = this.jugACapacity;
            return next;
        }

        public State fillB(State state) {
            State next = new State();
            next.jugAContained = state.jugAContained;
            next.jugBContained = this.jugBCapacity;
            return next;
        }

        public State pourA2B(State state) {
            State next = new State();
            int contained = state.getContained();
            if (contained > this.jugBCapacity) {
                next.jugBContained = this.jugBCapacity;
                next.jugAContained = contained - this.jugBCapacity;
            } else {
                next.jugAContained = 0;
                next.jugBContained = contained;
            }
            return next;
        }

        public State pourB2A(State state) {
            State conjugatedState = new State(state.jugBContained, state.jugAContained);
            State conjugatedNext = conjugated.pourA2B(conjugatedState);
            return new State(conjugatedNext.jugBContained, state.jugAContained);
        }

        public State clearA(State state) {
            State next = new State();
            next.jugAContained = 0;
            next.jugBContained = state.jugBContained;
            return next;
        }

        public State clearB(State state) {
            State next = new State();
            next.jugBContained = 0;
            next.jugAContained = state.jugAContained;
            return next;
        }
    }
}

//public class P365 implements Solution {
//    private final int x;
//    private final int y;
//    private final int z;
//    @Override
//    public Answer solve() {
//        Set<String> visited = new HashSet<>();
//        visited.add("0_0");
//        State state0 = new State(0, 0);
////        if (pourX())
//
//        return null;
//    }
//
//    @AllArgsConstructor
//    private static class State {
//        public int xV;
//        public int yV;
//
//        @Override
//        public String toString() {
//            return "State{" +
//                    "xV=" + xV +
//                    ", yV=" + yV +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            State state = (State) o;
//            return xV == state.xV && yV == state.yV;
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(xV, yV);
//        }
//    }
//
//    private State fillX(State prev, Set<String> set, int z) {
//        return new State(x, prev.yV);
//    }
//    private State pourXIntoY(State prev) {
//        int delta = y - prev.yV;
//        // 倒完
//        if (delta > prev.xV) {
//            return new State(0, prev.xV + prev.yV);
//        } else {
//            return new State(prev.xV - delta, y);
//        }
//    }
//    private State pourX(State prev) {
//        return new State(0, prev.yV);
//    }
//
//    private State fillY(State prev) {
//        return new State(prev.xV, y);
//    }
//    private State pourYIntoX(State prev) {
//        int delta = x - prev.xV;
//        // 倒完
//        if (delta > prev.yV) {
//            return new State(prev.xV + prev.yV, 0);
//        } else {
//            return new State(x,prev.yV - delta);
//        }
//    }
//    private State pourY(State prev) {
//        return new State(prev.xV, 0);
//    }
//
//    @Override
//    public String toString() {
//        return "P365{" +
//                "x=" + x +
//                ", y=" + y +
//                ", z=" + z +
//                '}';
//    }
//}
