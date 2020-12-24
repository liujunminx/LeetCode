package com.leetcode.algorithm.linkedlist;

import java.util.List;

public class RemoveNthNodeFromEndOfList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

    public ListNode removeNthFromEnd(ListNode head, int n){
        if (head.next == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        int length = 0;
        while (first != null){
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0){
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd01(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        while (n > 0){
            n--;
            first = first.next;
        }

        // first为空时，second在指定删除位置
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 1; i < 10; i++){
            ListNode node = new ListNode(i);
            p.next = node;
            p = p.next;
        }
        p = head;
        while (p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        r.removeNthFromEnd01(head, 4);
        System.out.println();
        p = head;
        while (p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

}
