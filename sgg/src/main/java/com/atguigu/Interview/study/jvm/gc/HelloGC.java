package com.atguigu.Interview.study.jvm.gc;
/*
*
* VM Options: -XX:+PrintGCDetails -XX:MetaspaceSize=128m
* */
public class HelloGC
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("****HelloGC");
        long totalMemory = Runtime.getRuntime().totalMemory(); //返回Java虚拟机中的内存总量 默认是最大内存的1/64
        long maxMemory = Runtime.getRuntime().maxMemory(); //返回Java虚拟机试图使用的最大内存量 默认是最大内存的1/4
        System.out.println("TOTAL_MEMORY(-Xms) = "+totalMemory+"(字节)、"+(totalMemory/(double)1024/1024)+"MB");
        System.out.println("MAX_MEMORY(-Xmx) = "+maxMemory+"(字节)、"+(maxMemory/(double)1024/1024)+"MB");
        // Thread.sleep(Integer.MAX_VALUE);
        // -Xms10m -Xmx10m -Xss1024k -XX:MetaspaceSize=512m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseSerialGC
        byte[] byteArray = new byte[50*1024*1024];
    }
}
