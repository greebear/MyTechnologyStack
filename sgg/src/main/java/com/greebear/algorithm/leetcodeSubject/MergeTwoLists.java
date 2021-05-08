package com.greebear.algorithm.leetcodeSubject;



public class MergeTwoLists
{
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode first = head;
        while(l1!=null&&l2!=null){
            if(l1.val>=l2.val){
                head=l1;
                l1 = l1.next;
            }
            else{
                head=l2;
                l2 = l2.next;
            }
            head=head.next;
        }

        head.next = l1 != null ? l1 : l2;

        return first;
    }
}
