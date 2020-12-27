package com.leetcode.algorithm.linkedlist;

public class MergeTwoSortedLists {
    class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode a = l1;
        ListNode b = l2;
        ListNode res = new ListNode(0);
        while (a != null && b != null){
            if (a.val <= b.val){
                res.next = a;
                a = a.next;
                res = res.next;
            }else {
                res.next = b;
                b = b.next;
                res = res.next;
            }
        }
        return res.next;
    }
}
