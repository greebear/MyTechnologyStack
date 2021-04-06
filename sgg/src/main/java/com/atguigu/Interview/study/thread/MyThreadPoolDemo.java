package com.atguigu.Interview.study.thread;

import java.util.concurrent.*;
/*
*
*
*
* 第4种获得/使用Java多线程的方式，线程池
*   第1种：继承Thread类
*   第2种：实现runable接口，接口没有返回值，不抛异常
*   第3种：实现callable接口，接口有返回值，会抛异常
* */
public class MyThreadPoolDemo
{
    public static void main(String[] args)
    {
        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        try
        {
            //模拟10个用户来办理业务，每个用户j就是一个来自外部的请求线程
            for (int i = 0; i < 10; i++) {
                //函数式接口可以lambda表达式
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }



    }

    private static void threadPoolInit()
    {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println();
        System.out.println();
        System.out.println();
        //末尾加s的都是辅助工具类
        //Array Arrays
        //Collection Collections
        //Executor Executors
        //ExecutorService threadPool = Executors.newFixedThreadPool(5); //一池5个处理线程 第一种
        //ExecutorService threadPool = Executors.newSingleThreadExecutor(); //一池1个处理线程 第二种
        ExecutorService threadPool = Executors.newCachedThreadPool(); //一池N个处理线程 第三种


        try
        {
            //模拟10个用户来办理业务，每个用户j就是一个来自外部的请求线程
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                //函数式接口可以lambda表达式
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
