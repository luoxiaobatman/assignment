package com.luoxiaobatman.assignment.leetcode.trivial;

import com.luoxiaobatman.assignment.datastructure.DoubleLinkedNode;
import com.luoxiaobatman.assignment.solution.Answer;
import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;
import lombok.AllArgsConstructor;

/**
 * <a href="https://zhuanlan.zhihu.com/p/42586566">Trivial</a>
 * 插入trivial, scores=1
 *
 * @implNote 链表实现
 * 时间复杂度avg:O(n^2)
 * 空间复杂度O(1)
 * stable
 *
 * @apiNote 基本上的有序数组时间复杂度O(n)
 */
@AllArgsConstructor
public class InsertionSort implements Solution {
    private final int[] ints;

    @Override
    public Answer solve() {
        DoubleLinkedNode<Integer> head = new DoubleLinkedNode<>(ints[0]);
        DoubleLinkedNode<Integer> prev = head;
        for (int i = 1; i < ints.length; i++) {
            DoubleLinkedNode<Integer> current = new DoubleLinkedNode<>(ints[i]);
            prev.setNext(current);
            current.setPrev(prev);
            prev = current;
        }

        DoubleLinkedNode<Integer> current;
        DoubleLinkedNode<Integer> next = head.getNext();

        while (next != null) {
            prev = current = next;
            next = next.getNext();
            while ((prev = prev.getPrev()) != null) {
                if (prev.getData() <= current.getData()) {
                    if (prev.getNext() == current) break;
                    current.removeSelf();
                    DoubleLinkedNode<Integer> tmp = prev.getNext();
                    prev.setNext(current);
                    current.setPrev(prev);
                    current.setNext(tmp);
                    if (tmp != null) {
                        tmp.setPrev(current);
                    }
                    break;
                }
            }
            if (prev == null) {
                current.removeSelf();
                current.setPrev(null);
                current.setNext(head);
                head.setPrev(current);
                head = current;
            }
        }
        int[] result = new int[ints.length];
        int i = 0;
        DoubleLinkedNode<Integer> node = head;
        do {
            result[i] = node.getData();
            i++;
        } while ((node = node.getNext()) != null);

        return Factory.of(Answer.class).newInstance(result);
    }
}
