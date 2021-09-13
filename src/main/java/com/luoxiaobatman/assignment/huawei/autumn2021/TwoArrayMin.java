package com.luoxiaobatman.assignment.huawei.autumn2021;

import java.util.*;

public class TwoArrayMin {
    public static class Pair implements Comparable<Pair> {
        public int xv;
        public int yv;

        public Pair(int xv, int yv) {
            this.xv = xv;
            this.yv = yv;
        }

        @Override
        public int compareTo(Pair other) {
            return sum() - other.sum();
        }

        public int sum() {
            return xv + yv;
        }
    }

    private static int[] readArray(Scanner scanner) {
        int xn = scanner.nextInt();
        int[] x = new int[xn];
        for (int i = 0; i < xn; i++) {
            x[i] = scanner.nextInt();
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] x = readArray(scanner);
        int[] y = readArray(scanner);
        int k = scanner.nextInt();
        int allSum = 0;
        Queue<Pair> q = new PriorityQueue<>();

        // 解法一, 暴力解
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                q.offer(new Pair(x[i], y[j]));
            }
        }
        while ((k = k - 1) > -1) {
            allSum += q.poll().sum();
        }
        System.out.println(allSum);

        // 解法二, 优化解, 但是过不了测试

//        int xi = 0;
//        int yi = 0;
//
//        while (k > 0) {
//            while (!q.isEmpty()) {
//                allSum += q.poll().sum();
//                k--;
//                if (k == 0) break;
//            }
//            if (xi <= x.length) {
//                for (int i = 0; i < yi; i++) {
//                    q.offer(new Pair(x[xi - 1], y[i]));
//                }
//            }
//            if (yi <= y.length) {
//                for (int i = 0; i < xi - 1; i++) {
//                    q.offer(new Pair(x[i], y[yi - 1]));
//                }
//            }
//            xi++;
//            yi++;
//        }
//        System.out.println(allSum);
    }
}
