package com.luoxiaobatman.assignment.leetcode.greedy;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

/**
 * 2**k 复杂度, 超时
 * <p>
 * 拼接最大数
 * <p>
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * <p>
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * <p>
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 * <p>
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 * <p>
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 执行用时：
 * 123 ms
 * , 在所有 Java 提交中击败了
 * 5.34%
 * 的用户
 * 内存消耗：
 * 39.2 MB
 * , 在所有 Java 提交中击败了
 * 20.42%
 * 的用户
 * 通过测试用例：
 * 101 / 101
 */
@AllArgsConstructor
public class P321HardFaster
        extends AbstractSolution<int[]> implements GenericSolution<int[]> {
    private int[] x;
    private int[] y;
    private int k;

    @Override
    public int[] doSolve() {
        assert x.length + y.length >= k;
        return maxNumber(x, y, k);
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        this.x = nums1;
        this.y = nums2;
        this.k = k;

        int[] champion = new int[k];
        int[] challenger;
        int[] xMono;
        int[] yMono;

        if (x.length >= k) {
            challenger = createMono(x, k);
            if (challenge(champion, challenger)) {
                champion = challenger;
            }
        }
        if (y.length >= k) {
            challenger = createMono(y, k);
            if (challenge(champion, challenger)) {
                champion = challenger;
            }
        }


        for (int i = 1; i < k; i++) {
            if (i > x.length || k - i > y.length) {
                continue;
            }
            xMono = createMono(x, i);
            yMono = createMono(y, k - i);
            challenger = combine(xMono, yMono);
            if (challenge(champion, challenger)) {
                champion = challenger;
            }
        }
        return champion;
    }

    private boolean challenge(int[] champion, int[] challenger) {
        for (int i = 0; i < champion.length; i++) {
            if (challenger[i] > champion[i]) {
                return true;
            } else if (challenger[i] < champion[i]) {
                return false;
            }
        }
        return false;
    }

    private int[] createMono(int[] number, int size) {
        Stack<Integer> monoStack = new ArrayMonoStack<>(true, size);
        for (int j : number) {
            monoStack.push(j);
        }
        int[] result;
        if (size != k) {
            result = new int[size + 1];
            result[size] = Integer.MIN_VALUE;
        } else {
            result = new int[k];
        }
        for (int i = 0; i < size; i++) {
            result[size - 1 - i] = monoStack.pop();
        }
        return result;
    }

    private int[] combine(int[] xMono, int[] yMono) {
        int[] result = new int[k];
        int xi = 0;
        int yi = 0;
        for (int i = 0; i < k; i++) {
            if (xMono[xi] > yMono[yi]) {
                result[i] = xMono[xi];
                xi++;
            } else if (xMono[xi] < yMono[yi]) {
                result[i] = yMono[yi];
                yi++;
            } else {
                if (chooseX(xMono, yMono, xi + 1, yi + 1)) {
                    result[i] = xMono[xi];
                    xi++;
                } else {
                    result[i] = yMono[yi];
                    yi++;
                }
            }
        }
        return result;
    }

    private boolean chooseX(int[] xMono, int[] yMono, int xi, int yi) {
        if (xMono[xi] > yMono[yi]) {
            return true;
        } else if (xMono[xi] < yMono[yi]) {
            return false;
        } else {
            if (xi + 1 == xMono.length) {
                return false;
            }
            if (yi + 1 == yMono.length) {
                return true;
            }
            return chooseX(xMono, yMono, xi + 1, yi + 1);
        }
    }

    public static class ArrayMonoStack<E extends Comparable<E>> extends ArrayStack<E> implements Stack<E> {
        private boolean inc;
        private int size;

        public ArrayMonoStack(boolean inc, int size) {
            super();
            this.inc = inc;
            this.size = size;
        }

        @Override
        public void push(E e) {
            if (this.size() < size) {
                super.push(e);
            } else {
                mono(e);
            }
        }

        private void mono(E e) {
            int compared;
            for (int i = 0; i < size - 1; i++) {
                compared = get(i).compareTo(get(i + 1));
                if ((inc && compared < 0) || (!inc && compared > 0)) {
                    remove(i);
                    add(e);
                    return;
                }
            }
            compared = get(size - 1).compareTo(e);
            if ((inc && compared < 0) || (!inc && compared > 0)) {
                remove(size - 1);
                add(e);
            }
        }
    }

    public static class ArrayStack<E> extends ArrayList<E> implements Stack<E> {
        @Override
        public E peek() {
            return get(size() - 1);
        }

        @Override
        public E pop() {
            return remove(size() - 1);
        }

        @Override
        public void push(E e) {
            add(e);
        }

        @Override
        public boolean empty() {
            return size() == 0;
        }
    }

    public interface Stack<E> {
        E peek();

        E pop();

        void push(E e);

        boolean empty();

        int size();
    }
}
