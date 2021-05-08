package com.greebear.algorithm.leetcodeDoubleMatch.M51.betterSolution;
// 双周赛：https://leetcode-cn.com/circle/discuss/MAuekp/
// 本题：https://leetcode-cn.com/problems/replace-all-digits-with-characters/
class Solution {
    // 备注，char类型加减是以ASCII码值进行的
    public String replaceDigits(String s) {
        char[] c = s.toCharArray();
        for (int i = 1; i < s.length(); i += 2) {
            c[i] = (char) (c[i]+c[i-1]-'0');
        }
        return new String(c);
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        String c1 = "a1c1e1";
        String o1 = solution.replaceDigits(c1);
        System.out.println(o1);

        System.out.println("================test");
        char a = 'a';
        char b = 'c';
        int c = b - a;
        System.out.println("char b - char a = int "+ c);
    }

}
