package com.luoxiaobatman.assignment.huawei.autumn2021;

import java.util.Scanner;

public class MovingDrawArea {
    public static class Point {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(Point prev, int[] instruction) {
            assert instruction.length == 2;
            int x = instruction[0];
            assert x >= prev.getX();
            int offsetY = instruction[1];
            this.x = x;
            this.y = prev.getY() + offsetY;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        private int x;
        private int y;
    }

    private static int area(Point prev, Point moveTo) {
        return (moveTo.getX() - prev.getX()) * Math.abs(prev.getY());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int maxX = scanner.nextInt();
        int[][] instructions = new int[N][];
        for (int i = 0; i < N; i++) {
            int[] instruction = new int[2];
            instruction[0] = scanner.nextInt();
            instruction[1] = scanner.nextInt();
            instructions[i] = instruction;
        }
        Point prev = new Point(0, 0);  // 画笔初始点
        int sumArea = 0;
        for (int[] instruction: instructions) {
            Point moveTo = new Point(prev, instruction);
            sumArea += area(prev, moveTo);
            prev = moveTo;
        }
        Point moveTo = new Point(prev, new int[] {maxX, -prev.getY()});
        sumArea += area(prev, moveTo);
        System.out.println(sumArea);
    }
}
