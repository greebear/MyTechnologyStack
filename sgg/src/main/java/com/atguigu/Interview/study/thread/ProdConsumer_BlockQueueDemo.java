package com.atguigu.Interview.study.thread;


import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource
{
    private volatile boolean FLAG = true; //默认开启，进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue)
    {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception
    {
        String data = null;
        boolean retValue;

        while (FLAG)
        {
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(retValue)
            {
                System.out.println(Thread.currentThread().getName()+"\t插入队伍"+data+"成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t插入队伍"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t大老板叫停了，表示FLAG=false，生产动作结束");

    }

    public void myConsumer() throws Exception
    {
        String result = null;
        while (FLAG)
        {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(null==result||result.equalsIgnoreCase(""))
            {
                System.out.println(Thread.currentThread().getName()+"\t超过2秒钟没有取到蛋糕，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t消费队列蛋糕"+result+"成功");
        }
    }

    public void stop() throws Exception
    {
        this.FLAG = false;
    }
}
/*
*
* volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
*
* */

public class ProdConsumer_BlockQueueDemo
{
    public static void main(String[] args) throws Exception
    {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+"\t生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(()-> {
            System.out.println(Thread.currentThread().getName()+"\t消费线程启动");
            System.out.println();
            System.out.println();
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consume").start();

        //暂停一会儿线程
        try{ TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("5秒钟时间到，大老板main线程叫停，活动结束");

        myResource.stop();


    }
}
