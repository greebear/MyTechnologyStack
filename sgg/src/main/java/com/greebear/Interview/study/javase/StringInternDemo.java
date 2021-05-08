package com.greebear.Interview.study.javase;

public class StringInternDemo {

    public static void main(String[] args) {

        String str0 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str0);
        System.out.println(str0.intern());
        System.out.println(str0 == str0.intern());

        System.out.println();

        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        System.out.println();

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());

//        private static Map<Integer,String> map2 = Collections.synchronizedMap(new HashMap<Integer,String>());


    }

}

