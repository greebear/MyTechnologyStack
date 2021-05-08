//package com.atguigu.algorithm;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//
//public class O48_lengthOfLongestSubstring
//{
//    public int lengthOfLongestSubstring(String s) {
//        char[] chars = s.toCharArray();
//        HashMap<Character, ListNode> hashMap = new HashMap<>();
//        for(Character c:chars){
//            ListNode node = new ListNode(c);
//            if(!hashMap.containsKey(node.value)){
//                hashMap.put(node.value, node.next);
//            }
//        }
//    }
//    public static class ListNode{
//        Character value;
//        ListNode next;
//        ListNode(Character c){
//            this.value=c;
//        }
//    }
//}
