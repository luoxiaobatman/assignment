package com.luoxiaobatman.assignment.interview.coding.cit;

import java.util.ArrayList;
import java.util.List;

/**
 * user_id order_id count
 *   1       1       10
 *   1       2       15
 *
 * SELECT `avg_count`, `user_id` FROM (SELECT AVG(`count`) AS `avg_count`, `user_id` FROM `user_order`\
 *   GROUP BY `user_id`) WHERE `avg_count` > 1000;
 */
public class Q2 {
    private static volatile Q2 instance;
//    static {
//        instance = singleton();
//    }
    public static Q2 singleton() {
        if (instance == null) {
            synchronized (Q2.class) {
                if (instance == null) {
                    instance = new Q2();
                }
            }
        }
        return instance;
    }

    private Q2() {}


    public static void main(String[] args) {
        // element < 1000
        List<Integer> integers = new ArrayList<>();
        int[] indexes = new int[1000];
        // O(n)
        for (Integer integer : integers) {
            indexes[integer]++;
            if (indexes[integer] > 1) {
                // 是重复的...

            }
        }
    }
}
