package com.luoxiaobatman.assignment.leetcode.milestone.easy;

import com.luoxiaobatman.assignment.leetcode.ListNode;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 */
@AllArgsConstructor
public class P25
        extends AbstractSolution<ListNode> implements GenericSolution<ListNode> {
    private final ListNode listNodes;
    private final int k;

    @Override
    public ListNode doSolve() {
        return reverseKGroup(listNodes, k);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        if (k == 1) return head;

        // 虚拟头节点, 方便编程
        ListNode virtualHead = new ListNode();
        virtualHead.next = head;

        // 上一轮的尾节点
        ListNode prevTail = virtualHead;
        // 当前轮的头(原始链表角度)
        ListNode segmentHead = head;
        // 遍历指针
        ListNode current = segmentHead;
        // 当前轮的尾(原始链表角度)
        ListNode segmentTail = current.next;
        // 避免loop
        segmentHead.next = null;
        int segmentK = 1;
        while (segmentTail != null) {
            ListNode tmp = segmentTail.next;
            segmentTail.next = current;
            current = segmentTail;
            segmentTail = tmp;
            segmentK++;
            if (segmentK == k) {
                prevTail.next = current;
                if (segmentTail == null) break;
                segmentK = 1;
                current = segmentTail;
                segmentTail = current.next;
                prevTail = segmentHead;
                segmentHead = current;
                // 避免loop
                segmentHead.next = null;
            }
        }
        // 最后一轮没有凑够k个节点, reverse back
        if (segmentK < k) {
            prevTail.next = reverse(current);
        }
        return virtualHead.next;
    }

    /**
     * trivial 链表反转
     */
    private ListNode reverse(ListNode node) {
        if (node == null) return null;
        ListNode prev = node;
        ListNode current = node.next;
        prev.next = null;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }
}
