package com.atguigu.Interview.study.jvm.gcroots;
import java.util.Arrays;

/*
*
* 在Java中，可作为GC Roots的对象有：
*
* 1. 虚拟机栈（栈帧中的局部变量区）中的对象;
* 2. 方法区中的类静态属性引用的对象;
*       (static是静态的，静态是一份全部实例共用的变量，被加载到方法区，方法区在Java7称为永久代，Java8称为元空间)
* 3. 方法区中常量引用的对象;
* 4. 本地方法栈中JNI（Native）方法引用的对象
*       (线程中start方法就是Native方法)
* */
public class GCRootDemo
{
    private byte[] byteArray = new byte[100*1024*1024];

    //private static GCRootDemo2 t2; // 2. 方法区中的类静态属性引用的对象;
    //private static final GCRootDemo3 t3 = new GCRootDemo(8); // 3. 方法区中常量引用的对象;

    public static void m1()
    {
        GCRootDemo t1 = new GCRootDemo(); // t1为虚拟机栈中的对象
        System.gc();
        System.out.println("第一次GC完成");
        System.out.println(Arrays.toString(t1.byteArray));
    }

    public static void main(String[] args)
    {
        m1();
    }


}
