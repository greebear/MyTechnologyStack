package com.greebear.algorithm.leetcodeSubject;

class reverseList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public ListNode reverseList(ListNode head) {
        // 终止条件
        if(head.next==null||head==null) return head;
        // 递归公式
        ListNode new_head = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return new_head;
    }

    public static void main(String[] args)
    {
        ListNode node_1 = null;

    }
}
