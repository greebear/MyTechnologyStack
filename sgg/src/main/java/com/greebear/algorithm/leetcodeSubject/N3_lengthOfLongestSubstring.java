package com.greebear.algorithm.leetcodeSubject;

import java.util.*;

public class N3_lengthOfLongestSubstring
{
    public static int lengthOfLongestSubstring(String s) {
        // 特殊情况判断
        if(s==null|| s.equals("")) return 0;
        // 初始化最大窗口长度
        int maxLen = 0;


        // 滑动窗口的左右指针
        int left=0;
        int right=-1;
        // 维护一个窗口内字符的哈希表
        HashMap<Character, Integer> map = new HashMap<>();
        // 开始遍历字符串
        while(left<s.length()&&right<s.length()-1){
            ++right;
            Character curChar = s.charAt(right);
            // 如果字符不存在，将字符保存到哈希表
            if(!map.containsKey(curChar)) {
                map.put(curChar, right);
                continue;
            }
            // 如果字符存在，计算最大窗口
            // 找到其位置，位置+1后赋值给左指针
            // 删除哈希表中的key
            if(right-left>maxLen) maxLen = right - left;
            left = map.get(curChar) + 1;
            map.remove(curChar);

        }
        // 如果是尾部跳出while循环 则取map的值
        if(map.size()>maxLen) maxLen = map.size();

        return maxLen;
    }

    public static void main(String[] args)
    {
        String case_1 = "abcabcbb";
        int output_1 = lengthOfLongestSubstring(case_1);
        System.out.println(output_1);

        String case_2 = "";
        int output_2 = lengthOfLongestSubstring(case_2);
        System.out.println(output_2);

        String case_3 = " ";
        int output_3 = lengthOfLongestSubstring(case_3);
        System.out.println(output_3);

        String case_4 = "a";
        int output_4 = lengthOfLongestSubstring(case_4);
        System.out.println(output_4);

        String case_5 = "au";
        int output_5 = lengthOfLongestSubstring(case_5);
        System.out.println(output_5);

        String case_6 = "abc";
        int output_6 = lengthOfLongestSubstring(case_6);
        System.out.println(output_6);

        String case_7 = "pwwkew";
        int output_7 = lengthOfLongestSubstring(case_7);
        System.out.println(output_7); //3


    }
}
