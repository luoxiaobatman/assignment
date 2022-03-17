package com.luoxiaobatman.assignment.util;

import com.luoxiaobatman.assignment.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ListNodeUtils {
    public static ListNode fromFullTable(int[] table) {
        if (table == null || table.length == 0) return null;
        ListNode first = new ListNode(table[0]);
        ListNode current = first;
        for (int i = 1; i < table.length; i++) {
            current.next = new ListNode(table[i]);
            current = current.next;
        }
        return first;
    }

    public static int[] toFullTable(ListNode listNode) {
        if (listNode == null) return null;
        List<Integer> lists = new ArrayList<>();
        while (listNode != null) {
            lists.add(listNode.val);
            listNode = listNode.next;
        }
        int[] ret = new int[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            ret[i] = lists.get(i);
        }
        return ret;
    }
}
