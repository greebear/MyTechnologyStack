package com.greebear.algorithm.leetcodeSubject.N1720;

import java.util.Arrays;

class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length+1];
        res[0] = first;
        for(int i=1;i<encoded.length-1;i++){
            System.out.println("=================");
            System.out.println("e\t"+encoded[i-1]);
            System.out.println("res\t"+res[i-1]);
            res[i] = encoded[i-1]^res[i-1];
            System.out.println("o\t"+res[i]);

        }
        return res;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] case_1 = {1,2,3};
        int[] res = solution.decode(case_1, 1);
        System.out.println(Arrays.toString(res));
    }
}