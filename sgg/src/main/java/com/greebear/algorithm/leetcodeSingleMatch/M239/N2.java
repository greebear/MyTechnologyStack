//package com.atguigu.algorithm.leetcodeSingleMatch.M239;
//
//class GetMinSwaps {
//    public int getMinSwaps(String num, int k) {
//        char[] c = num.toCharArray();
//        int left = num.length()-1;
//        int right = num.length();
//        if(right>=left){
//            --left;
//            --right;
//        }
//        if(left<right){
//            char tmp = c[left];
//            c[left] = c[right];
//            c[right] = tmp;
//        }
//
//    }
//
//    public static void main(String[] args)
//    {
//        GetMinSwaps solution = new GetMinSwaps();
//        solution.getMinSwaps("13112",3);
//
//    }
//}
