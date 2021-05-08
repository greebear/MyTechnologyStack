package com.greebear.Interview.study.jvm.ref;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo
{
    public static void main(String[] args)
    {
        myHashmap();
        System.out.println("===================");
        myWeakHashmap();
    }

    private static void myHashmap()
    {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";

        map.put(key, value);
        System.out.println(map);

        key=null;
        System.out.println(map);

        System.gc();
        System.out.println(map+"\t"+map.size());
    }

    private static void myWeakHashmap()
    {

        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(1); //用new Integer(1)才会回收，有时间看看为什么
        String value = "HashMap";

        map.put(key, value);
        System.out.println(map);

        key=null;
        System.out.println(map);

        System.gc();
        System.out.println(map+"\t"+map.size());

    }
}
