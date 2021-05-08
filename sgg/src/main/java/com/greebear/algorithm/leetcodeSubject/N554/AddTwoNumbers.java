package com.greebear.algorithm.leetcodeSubject.N554;


public class AddTwoNumbers
{
public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode();
        ListNode before = new ListNode();
        ListNode first_node = head;
        while(l1!=null||l2!=null){
            int l1_val=l1==null?0:l1.val;
            int l2_val=l2==null?0:l2.val;
            int tmp_val = l1_val + l2_val + carry;
            head.val = tmp_val%10;
            carry = tmp_val/10;
            l1 = l1.next;
            l2 = l2.next;
            // 下个节点
            head.next = new ListNode();
            before = head;
            head = head.next;
        }
        if(carry!=0)
            head.val = carry;
        else
            before.next = null;

        return first_node;
    }

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1, l2);
    }
}
