package com.atguigu.Interview.study.thread;

public class Name
{
    private static String instance = null;
    private Name()
    {
        System.out.println(instance);
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法singletonDemo()");
    }

    public static String getInstance()
    {
        instance = "abc";
        return instance;
    }


    public static void main(String[] args)
    {
        Name a = new Name();
        Name.getInstance();
        Name b = new Name();
    }
}
