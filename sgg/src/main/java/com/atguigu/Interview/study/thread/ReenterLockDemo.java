package com.atguigu.Interview.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 线程操作资源类
class Phone implements Runnable
{
    public synchronized void sendSMS() throws Exception
    {
        System.out.println(Thread.currentThread().getName()+"\t invoked sendSMS()");
        sendEmail();
    }
    public synchronized void sendEmail() throws Exception
    {
        System.out.println(Thread.currentThread().getName()+"\t ###### invoked sendEmail()");
    }

    // =====================================================================
    Lock lock = new ReentrantLock();
    @Override
    public void run()
    {
        get();
    }

    public void get()
    {
        lock.lock();
        lock.lock(); // 有几个lock就对应几个unlock
        try {
            System.out.println(Thread.currentThread().getName()+"\t invoked get()");
            set();
        }
        finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void set()
    {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t ###### invoked set()");
        }
        finally {
            lock.unlock();
        }
    }
}

/*
* 可重入锁(又名递归锁, ReentrantLock)
* 指的是同一线程外层函数获取锁之后，内层递归函数仍然能获取该锁的代码，
* 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
* 也即是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块。
*
* 案例一： Synchronized就是一个典型的可重入锁
* t1	 invoked sendSMS()                 t1线程在进入外层方法获取锁的时候
* t1	 ###### invoked sendEmail()        t1线程在进入内存方法会自动获取锁
*
* t2	 invoked sendSMS()
* t2	 ###### invoked sendEmail()
*
* 案例二： ReentrantLock就是一个典型的可重入锁
*
* */
public class ReenterLockDemo
{
    public static void main(String[] args) throws Exception
    {
        Phone phone = new Phone();
        new Thread(()-> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(()-> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        // 暂停一会儿线程
        try{ TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();



        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);

        t3.start();
        t4.start();
    }
}
