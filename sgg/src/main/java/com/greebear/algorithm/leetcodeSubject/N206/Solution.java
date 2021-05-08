package com.greebear.algorithm.leetcodeSubject.N206;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

    public ListNode reverseList(ListNode head) {
        // 终止条件
        if(head==null||head.next==null) return head;
        // 递归公式
        ListNode new_head = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return new_head;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        // case
        ListNode node_1 = null;
        ListNode head_1 = solution.reverseList(node_1);
        System.out.println(head_1);
    }
}
