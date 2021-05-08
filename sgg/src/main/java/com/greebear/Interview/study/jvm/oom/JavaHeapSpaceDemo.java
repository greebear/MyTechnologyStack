package com.greebear.Interview.study.jvm.oom;

import java.util.Random;
/*
* -Xms10m -Xmx10m
*
*
* */
public class JavaHeapSpaceDemo
{
    public static void main(String[] args)
    {
        byte[] bytes = new byte[80*1024*1024]; // 80MB 这个更简单
        String str = "atguigu";

        while (true)
        {
            str += str + new Random().nextInt(11111)+new Random().nextInt(222222);
            str.intern();
        }


        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}
