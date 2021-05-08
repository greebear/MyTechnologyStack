package com.greebear.Interview.study.jvm.oom;
/*
* 常见于递归算法
*
* */
public class StackOverflowErrorDemo
{
    public static void main(String[] args)
    {
        stackOverflowError();
    }

    private static void stackOverflowError()
    {
        stackOverflowError(); // Exception in thread "main" java.lang.StackOverflowError
    }
}
