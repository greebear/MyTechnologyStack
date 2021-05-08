package com.greebear.Interview.study.thread;

import java.util.concurrent.*;

public class T1
{
    public static void main(String[] args)
    {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                100L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3), // 等候区
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try
        {
            for (int i = 1; i <= 8; i++) {
                int tmpI = i;
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"号窗口，"+"服务顾客"+tmpI);
                    //暂停一会儿线程
                    try{ TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e) { e.printStackTrace(); }

                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
