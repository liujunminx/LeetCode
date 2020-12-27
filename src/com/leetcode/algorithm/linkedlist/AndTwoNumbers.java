package com.leetcode.algorithm.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AndTwoNumbers {
        public static ListNode addTwoNumbers(ListNode p1, ListNode p2){
            ListNode dummyHead = new ListNode(0);
            ListNode p =p1, q = p2, curr = dummyHead;// 第三个链表合并两个链表
            int carry = 0;
            while (p != null || q != null){
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10; // 近卫加一
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if (carry > 0){// 最后的进位
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }

    public static void main(String[] args) {
        ListNode p = new ListNode(9);
        p.next = new ListNode(9);
        ListNode q = new ListNode(9);
        q.next = new ListNode(9);
        q.next.next = new ListNode(9);
        q.next.next.next = new ListNode(9);
        ListNode result = addTwoNumbers(q, p);
//        System.out.println(result.val);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
