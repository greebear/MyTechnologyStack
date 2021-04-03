package com.atguigu.Interview.study.thread;

public class VolatileDemoSortCase
{
    // case1
    public void mySort()
    {
        int x = 11; //语句1
        int y = 12; //语句2
        x = x + 5; //语句3
        y = x * x; //语句4
    }


/*
* 因为指令重排，所以可能出现下面这些情况
* 1234
* 2134
* 1324
* 但是因为数据依赖性的影响，所以不会出现4在第一行出现的情况
* */

    // case2
    int a = 0;
    boolean flag = false;

    public void method01()
    {
        a = 1;  //语句1
        flag = true;  //语句2
    }

    public void method02()
    {
        if(flag)
        {
            a = a + 5;
            System.out.println("retValue: "+a);
        }
    }
}

/*
* 多线程环境中线程交替执行，由于编译器优化重排的存在，两个线程中使用的变量能否保证一致性是无法确定的，结果无法预测
* */