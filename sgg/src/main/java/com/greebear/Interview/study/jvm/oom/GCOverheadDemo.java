package com.greebear.Interview.study.jvm.oom;

import java.util.ArrayList;
import java.util.List;
/*
* -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
* 直接内存太大了(比如16G)，设置小一些
* 我将MaxDirectMemorySize设置为1m才能看到效果，5m则是出现了heap的oom
*
* */
public class GCOverheadDemo
{
    public static void main(String[] args)
    {
        int i = 0;
        List<String> list = new ArrayList<>();

        try
        {
            while (true)
            {
                list.add(String.valueOf(i++).intern());
            }
        } catch (Throwable e) {
            System.out.println("*****************i:"+i);
            e.printStackTrace();
            throw e;
        }
    }
}
