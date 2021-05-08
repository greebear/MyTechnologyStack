package com.greebear.Interview.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//字节码演示
public class T1
{
    public volatile int n = 0;

    public void add()
    {
        n++;
    }

    public static void main(String[] args)
    {
        Lock lock = new ReentrantLock(true);
    }
}
