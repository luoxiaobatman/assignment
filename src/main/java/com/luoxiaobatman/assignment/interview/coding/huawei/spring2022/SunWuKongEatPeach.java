package com.luoxiaobatman.assignment.interview.coding.huawei.spring2022;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
@AllArgsConstructor
public class SunWuKongEatPeach extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int arg;

    @Override
    public Integer doSolve() {
        return arg;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> fruitCounts = new ArrayList<>();
        while (in.hasNext()) {
            try {
                fruitCounts.add(in.nextInt());
            } catch (Exception e) {
                System.out.println("-1");
                return;
            }
        }
        if (fruitCounts.size() < 2) {
            System.out.println("-1");
            return;
        }
        Integer countingDown = fruitCounts.remove(fruitCounts.size() - 1);
        if (fruitCounts.size() > countingDown) {
            System.out.println("-1");
            return;
        }
        int bound = 0;
        int guess = fruitCounts.get(0);
        for (Integer fruitCount : fruitCounts) {
            if (fruitCount < 0) {
                System.out.println("-1");
                return;
            }
            guess = Math.max(fruitCount, guess);
        }
        // 二分查找
        while (guess - bound > 0) {
            int nextSpeed = ((guess - bound) / 2) + bound;
            if (nextSpeed == 0) break;
            // 速度减半 能吃完
            if (passGuess(fruitCounts, countingDown, nextSpeed)) {
                guess = nextSpeed;
            } else {
                bound = nextSpeed + 1;
            }
        }
        System.out.println(guess);
    }

    private static boolean passGuess(List<Integer> counts, int countingDown, int speed) {
        int spent = 0;
        for (Integer fruitCount : counts) {
            if (fruitCount % speed > 0) {
                spent = spent + fruitCount / speed + 1;
            } else if (fruitCount == 0) {
                spent = speed + 1;
            } else {
                spent = spent + fruitCount / speed;
            }
        }
        return countingDown >= spent;
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int ans = 0, x;
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                x = sc.nextInt();
//                ans += x;
//            }
//        }
//        System.out.println(ans);
//    }
}
