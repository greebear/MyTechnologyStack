//package com.atguigu.algorithm.sort.majorityElement;
//
//import java.util.*;
//
//public class majorityElement_v2
//{
//    public List<Integer> majorityElement(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//        int a = nums[0];
//        int a_c = 1;
//        int b = Integer.parseInt(null);
//        int b_c = 0;
//        for(int num:nums){
//            if(a!=num){
//                if((b)&&(b!=0)){
//                    --b_c;
//                }
//                else{
//                    b = num;
//                    b_c =1;
//                }
//            }
//            else{
//
//            }
//        }
//
//    public static void main(String[] args)
//    {
//        int[] data= new int[]{1,1,1,3,3,2,2,2};
//        System.out.println(Arrays.toString(data));
//        List<Integer> list = majorityElement(data);
//        System.out.println(list);
//
//    }
//}
