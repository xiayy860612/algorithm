package com.study.algo.leetcode.level_1.double_point;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * <p>
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class Program876 {

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

    public ListNode middleNode1(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        while (true) {
            if (quick.next == null) {
                return slow;
            }

            if (quick.next.next == null) {
                return slow.next;
            }

            quick = quick.next.next;
            slow = slow.next;
        }
    }

    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
