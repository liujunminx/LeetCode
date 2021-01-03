package com.leetcode.algorithm.linkedlist;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                p.next = a;
                a = a.next;
                p = p.next;
            } else {
                p.next = b;
                b = b.next;
                p = p.next;
            }
        }
        while (a != null) {
            p.next = a;
            p = p.next;
            a = a.next;
        }
        while (b != null) {
            p.next = b;
            p = p.next;
            b = b.next;
        }
        return res.next;
    }

    public ListNode mergeTwoSorts01(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode tail = dummy;
        while (tail != null) {
            if (l1 == null) {
                tail.next = l2;
                break;
            }
            if (l2 == null) {
                tail.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode().createListNode();
        ListNode l2 = new ListNode().createListNode();
        ListNode res = new MergeTwoSortedLists().mergeTwoLists(l1, l2);
        new ListNode().printListNode(res);
    }
}
