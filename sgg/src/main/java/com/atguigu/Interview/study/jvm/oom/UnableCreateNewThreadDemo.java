package com.atguigu.Interview.study.jvm.oom;

public class UnableCreateNewThreadDemo
{
    public static void main(String[] args)
    {
        for (int i = 0; ; i++)
        {
            System.out.println("************* i="+i);
            new Thread(()-> {
                try {Thread.sleep(Integer.MAX_VALUE);} catch (InterruptedException e) {e.printStackTrace();}
            }, String.valueOf(i)).start();
        }
    }
}
