package com.atguigu.algorithm;

public class N5_longestPalindrome
{
    public String longestPalindrome(String s) {
        int maxLen = 0,start=0,end = 0;

        //特殊情况判断
        if(s==null||s.length()<1) return "";

        //遍历字符串
        for(int i = 0; i<s.length(); i++){
            int len_1 = lengthExpand(s, i,i);
            int len_2 = lengthExpand(s, i,i+1);
            int len = Math.max(len_1, len_2);
            if(len>maxLen)
            {
                maxLen=len;
                start = i- (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }

    public int lengthExpand(String s, int left, int right){
        while(left>=0&&right<s.length()){
            if(s.charAt(left)!=s.charAt(right)) break;
            --left;
            ++right;
        }
        return right-left-1;
    }

    public static void main(String[] args)
    {
        N5_longestPalindrome solution = new N5_longestPalindrome();

        String case_1 = "babad";
        String output_1 = solution.longestPalindrome(case_1);
        System.out.println(output_1);
    }
}
