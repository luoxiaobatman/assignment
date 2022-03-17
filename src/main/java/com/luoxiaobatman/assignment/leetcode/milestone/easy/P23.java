package com.luoxiaobatman.assignment.leetcode.milestone.easy;

import com.luoxiaobatman.assignment.leetcode.ListNode;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 */
@AllArgsConstructor
public class P23
        extends AbstractSolution<ListNode> implements GenericSolution<ListNode> {
    private final ListNode[] listNodes;

    @Override
    public ListNode doSolve() {
        return mergeKLists(listNodes);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                q.offer(listNode);
            }
        }
        if (q.isEmpty()) return null;
        ListNode head = q.poll();
        if (head.next != null) q.offer(head.next);
        ListNode current = head;
        ListNode next;
        while ((next = q.poll()) != null) {
            current.next = next;
            if (next.next != null) q.offer(next.next);
            current = next;
        }
        return head;
    }
}
