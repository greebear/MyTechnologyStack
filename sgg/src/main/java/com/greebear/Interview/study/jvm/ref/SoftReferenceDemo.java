package com.greebear.Interview.study.jvm.ref;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo
{
    /*
    * 内存够用的时候就保留，不够用就回收
    *
    * */

    public static void softRef_Memory_Enough()
    {
        Object o1 = new Object();
        SoftReference<Object> o2 = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(o2.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(o2.get());
    }
    /*
    * JVM配置，故意产生大对象并配置小的内存，让它内存不够用了导致OOM，看软引用的回收情况
    * -Xms5m -Xmx5m -XX:+PrintGCDetails
    * */
    public static void softRef_Memory_NotEnough()
    {
        Object o1 = new Object();
        SoftReference<Object> o2 = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(o2.get());

        o1 = null;
        System.gc();

        try
        {
            byte[] bytes = new byte[30*1024*1024];

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(o2.get());
        }


    }

    public static void main(String[] args)
    {
        softRef_Memory_Enough();
        System.out.println("===========================================");
        softRef_Memory_NotEnough();
    }
}



