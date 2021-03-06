package com.greebear.Interview.study.thread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/*
* 集合线程不安全的问题
* ArrayList
* */
public class ContainerNotSafeDemo
{
    public static void main(String[] args)
    {
        Map<String, String> map = new ConcurrentHashMap<>(); //Collections.synchronizedMap(new HashMap<>());//HashMap<>();
        for (int i = 0; i < 30; i++)
        {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void setNotSafe()
    {
        Set<String> set = new CopyOnWriteArraySet<>();//Collections.synchronizedSet(new HashSet<>());//new HashSet<>();
        for (int i = 0; i < 30; i++)
        {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
        HashSet<String> hashSet = new HashSet<>();
    }

    private static void listNotSafe()
    {
        //        //单线程情况下
//        // 比较高效的写法
//        List<String> list = Arrays.asList("a", "b", "c");
//        list.forEach(System.out::println);
//
//        // 简单写法
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//
//        for (String element :list){
//            System.out.println(element);
//        }

        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 3; i++)
        {
            new Thread(()-> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();

            //java.util.ConcurrentModificationException
            //ArrayList在高并发下常见的线程不安全问题

            /*
            * 1 故障现象
            *       java.util.ConcurrentModificationException
            *
            * 2 导致原因
            *   并发争抢修改导致，参考我们的花名册签名情况
            *   一个人正在写，另外一个人过来抢夺。导致数据不一致异常
            * 3 解决方案
            *   3.1 new Vector<>();
            *   3.2 Collections.synchronizedList(new ArrayList<>());
            *   3.3 new CopyOnWriteArrayList<>(); 写时复制，适用于读多写少的场景
            * 4 优化建议（同样的错误不犯第2次）
            *
            * */


/** 笔记
 *  写时复制
 CopyOnWrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器Object[]添加，而是先将当前容器Object[]进行Copy，
 复制出一个新的容器Object[] newElements，然后往新的容器Object[] newElements里添加元素，添加元素之后，
 再将原容器的引用指向新的容器 setArray(newElements);。这样做的好处是可以对CopyOnWrite容器进行并发的读，
 而不需要加锁，因为当前容器不会添加任何元素，所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器

 public boolean add(E e) {
 final ReentrantLock lock = this.lock;

 lock.lock();
 try {
 Object[] elements = getArray();
 int len = elements.length;
 Object[] newElements = Arrays.copyOf(elements, len + 1);
 newElements[len] = e;
 setArray(newElements);
 return true;
 } finally {
 lock.unlock();
 }
 }
 * */
        }
    }
}

