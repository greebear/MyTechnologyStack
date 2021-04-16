package com.atguigu.algorithm.sort;

public class Test
{
    public static void main(String[] args)
    {
        // a++ 打印测试
        int a = 1;
        for (int i = 0; i < 99; i++) {
            a = a++;
        }
        System.out.println(a);
        // 数组长度打印测试
        int[] a_list= new int[]{3,2,3};
        System.out.println(a_list.length);
        System.out.println(a_list.length/3);
    }
}
