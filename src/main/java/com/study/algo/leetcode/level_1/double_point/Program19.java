package com.study.algo.leetcode.level_1.double_point;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Program19 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 计算要删除节点的位置
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            ++length;
        }
        return length;
    }

    /**
     * 栈
     */
    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; ++i) {
            stack.pop();
        }

        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return dummy.next;
    }

    /**
     * 双指针
     */
    public ListNode removeNthFromEnd_3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        for (int i = 0; i  < n; ++i) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
