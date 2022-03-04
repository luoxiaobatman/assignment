package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 *
 */
@AllArgsConstructor
public class P85
        extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int[][] source;

    @Override
    public Integer doSolve() {
        char[][] matrix = new char[source.length][];
        for (int i = 0; i < matrix.length; i++) {
            char[] line = new char[source[i].length];
            matrix[i] = line;
            for (int j = 0; j < line.length; j++) {
                line[j] = (char)('0' + source[i][j]);
            }
        }
        return maximalRectangle(matrix);
    }

    public int maximalRectangle(char[][] matrix) {
        int[][] intMatrix = new int[matrix.length][];
        int maximalRectangle = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int[] line = new int[matrix[i].length];
            intMatrix[i] = line;
            if (i == 0) {
                for (int j = 0; j < line.length; j++) {
                    line[j] = matrix[i][j] - '0';
                }
            } else {
                for (int j = 0; j < line.length; j++) {
                    if (matrix[i][j] == '0') {
                        line[j] = 0;
                    } else {
                        line[j] = 1 + intMatrix[i - 1][j];
                    }
                }
            }

            maximalRectangle = Math.max(maximalRectangle, largestRectangleArea(line));
        }
        return maximalRectangle;
    }



    public int largestRectangleArea(int[] heights) {
        Pillar[] pillars = new Pillar[heights.length];
        for (int i = 0; i < heights.length; i++) {
            Pillar pillar = new Pillar();
            pillar.index = i;
            pillar.height = heights[i];
            pillars[i] = pillar;
        }
        PillarMonoStack monoStack = new PillarMonoStack();
        int largestArea = Integer.MIN_VALUE;
        for (int i = 0; i < pillars.length; i++) {
            Pillar pillar = pillars[i];
            Queue<Pillar> pops = monoStack.mono(pillar);
            Pillar poll;
            while ((poll = pops.poll()) != null) {
                largestArea = Math.max(largestArea, poll.height * (i - poll.index));
                pillar.index = poll.index;
            }
        }
        Pillar pop = monoStack.pop();
        while (true) {
            largestArea = Math.max(largestArea, pop.height * (pillars.length - pop.index));
            try {
                pop = monoStack.pop();
            } catch (NoSuchElementException ignored) {break;}
        }

        return largestArea;
    }

    public static class Pillar {
        int index;
        int height;
    }

    /**
     * 非严格单增栈
     */
    public static class PillarMonoStack extends ArrayDeque<Pillar> implements Deque<Pillar> {
        public Queue<Pillar> mono(Pillar pillar) {
            Queue<Pillar> q = new LinkedList<>();
            while (peek() != null && peek().height > pillar.height) {
                q.offer(pop());
            }
            super.push(pillar);
            return q;
        }
    }
}
