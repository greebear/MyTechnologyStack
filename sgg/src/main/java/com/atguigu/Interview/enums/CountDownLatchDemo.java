package com.atguigu.Interview.enums;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo
{
    public static void main(String[] args) throws Exception
    {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i < 7; i++)
        {
            new Thread(()-> {
                System.out.println(Thread.currentThread().getName()+"\t上完自习，离开教室");
                countDownLatch.countDown();
            }, CountryEnum.forEach_countryEnum(i).getRetMessage()).start();
        }


        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t ****************班长最后关门走人");
        System.out.println();
        System.out.println(CountryEnum.ONE);
        System.out.println(CountryEnum.ONE.getRetCode());
        System.out.println(CountryEnum.ONE.getRetMessage());
    }

    private static void closeDoor() throws InterruptedException
    {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i < 7; i++)
        {

            new Thread(()-> {
                System.out.println(Thread.currentThread().getName()+"\t上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t ****************班长最后关门走人");
    }
}
