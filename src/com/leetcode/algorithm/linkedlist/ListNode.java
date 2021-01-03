package com.leetcode.algorithm.linkedlist;

public class ListNode {
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

    public ListNode createListNode() {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return head.next;
    }

    public void printListNode(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
