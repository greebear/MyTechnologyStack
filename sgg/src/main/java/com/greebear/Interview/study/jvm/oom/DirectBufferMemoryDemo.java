package com.greebear.Interview.study.jvm.oom;

import java.nio.ByteBuffer;

/*
* -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
*
*
* */
public class DirectBufferMemoryDemo
{
    public static void main(String[] args)
    {
        System.out.println("配置的maxDirectMemory:"+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");
        //暂停一会儿线程
        try{ Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        //初始化6MB
        ByteBuffer bb = ByteBuffer.allocateDirect(6*1024*1024);
        //Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
    }
}
