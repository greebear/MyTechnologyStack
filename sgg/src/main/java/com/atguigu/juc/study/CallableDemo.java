package com.atguigu.juc.study;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


//class MyThread implements Runnable //Runnable接口不会抛异常
//{
//
//    @Override
//    public void run()
//    {
//
//    }
//}

class MyThread implements Callable<Integer> //Callable接口会抛异常
{

    @Override
    public Integer call() throws Exception
    {
        System.out.println("****************** come in callable");
        return 1024;
    }
}



public class CallableDemo
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        // 两个线程，一个main主线程，一个是AAfutureTask
        // FutureTask(Callable<V> callable)
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread()); // 如果A B线程同时调用同一个futureTask，只计算一次(复用)
        FutureTask<Integer> futureTask_copy = new FutureTask<>(new MyThread()); // 通过new一个新的futureTask来进行多次计算callable里面的内容


        new Thread(futureTask, "AA").start();
        new Thread(futureTask_copy, "BB").start();


        int result01 = 100;
        int result02 = futureTask.get(); //要求获得callable线程的计算结果，如果没有计算完成就要去强求，会导致堵塞，直到计算完成
        // 类似自旋的方式获取
        // while (!futureTask.isDone())
        // {
        //     futureTask.get();
        // }

        System.out.println("****************** result："+(result01+result02));

    }
}
