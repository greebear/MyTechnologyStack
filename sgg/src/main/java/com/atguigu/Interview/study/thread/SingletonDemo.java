package com.atguigu.Interview.study.thread;

public class SingletonDemo
{
    private static volatile SingletonDemo instance = null;
    private SingletonDemo()
    {
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法singletonDemo()");
    }
    //DCL(Double Check Lock双端检锁机制)
    //public static synchronized SingletonDemo getInstance()//使用synchronized可以保证单例，但是整个线程都锁住了，保证了数据一致性，但并发性下降
    public static SingletonDemo getInstance()
    {
        if(instance == null)
        {
            synchronized (SingletonDemo.class)
            {
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args)
    {
//        //单线程(main线程的操作动作...)
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//
//        System.out.println();
//        System.out.println();
//        System.out.println();

        //并发多线程后，情况发生了很大的变化
        for (int i = 0; i < 10; i++)
        {
            new Thread(()-> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
