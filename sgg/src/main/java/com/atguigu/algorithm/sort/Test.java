package com.atguigu.algorithm.sort;

import java.util.*;

public class Test
{
    public static void main(String[] args)
    {
        // a++ 打印测试
        int a = 1;
        for (int i = 0; i < 99; i++) {
            a = a++;
        }
        System.out.println(a);
        // 数组长度打印测试
        int[] a_list= new int[]{3,2,3};
        System.out.println(a_list.length);
        System.out.println(a_list.length/3);

        System.out.println("=================================");
        // 数据结构
        // 队列
        System.out.println("=================================队列Queue LinkedList<>");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 元素 1 入队
        queue.offer(2); // 元素 2 入队
        System.out.println("queue:\t"+queue);
        System.out.println("peek:\t"+queue.peek());
        queue.poll();   // 出队 -> 元素 1
        queue.poll();   // 出队 -> 元素 2

        System.out.println("=================================双端队列Deque LinkedList<>");
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1); // 元素 1 入队
        deque.offer(2); // 元素 2 入队
        System.out.println("deque:\t"+deque);
        System.out.println("peekFirst:\t"+deque.peekFirst());
        System.out.println("peekLast:\t"+deque.peekLast());
        deque.poll();   // 出队 -> 元素 1
        deque.poll();   // 出队 -> 元素 2
        System.out.println(deque.peekFirst());


        // 栈
        System.out.println("=================================栈Stack<>");
        Stack<Integer> stack_1 = new Stack<>();
        stack_1.push(1); // 元素 1 入栈
        stack_1.push(2); // 元素 2 入栈
        System.out.println(stack_1);
        System.out.println(stack_1.peek());
        stack_1.pop();   // 出栈 -> 元素 2
        stack_1.pop();   // 出栈 -> 元素 1

        System.out.println("=================================栈LinkedList<>");
        LinkedList<Integer> stack_2 = new LinkedList<>();

        stack_2.addLast(1);   // 元素 1 入栈
        stack_2.addLast(2);   // 元素 2 入栈
        System.out.println(stack_2);
        System.out.println(stack_2.peek());
        stack_2.removeLast(); // 出栈 -> 元素 2
        stack_2.removeLast(); // 出栈 -> 元素 1

        // Hashmap
        System.out.println("=================================Hashmap");
        HashMap<String, Integer> hashMap = new LinkedHashMap<>();
        hashMap.put("a",1);
        System.out.println(hashMap.containsKey("b"));
        hashMap.merge("a",1, (old_val, new_val)->old_val+new_val);
        System.out.println(hashMap.get("a"));

        // Hashset
        System.out.println("=================================Hashmset");
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("a");
        Boolean hashKey = hashSet.contains("a");
        System.out.println(hashKey);

        // 整除、求余
        System.out.println("=================================整除、求余");
        System.out.println(10/3);
        System.out.println(10%3);
        System.out.println((float)10/3);

        // 字符串
        System.out.println("=================================List中的字符串");
        String str = "abc";
        List<String> strList= new LinkedList<>();
        strList.add(str);
        strList.toArray(new String[2]);
        String index_0 = strList.get(0);
        System.out.println(index_0);
        System.out.println(strList);

        // 字符串转字符Array
        System.out.println("=================================字符串转CharArray");
        char[] c = str.toCharArray();
        System.out.println(c[2]);
//        String.valueOf()

        // int[]
        System.out.println("=================================数组int[]");
        int[] int_array = new int[3];
        int_array[0] = 1;
        System.out.println(Arrays.toString(int_array));

        // matrix[][]
        System.out.println("=================================矩阵matrix[][]");
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        System.out.println(matrix.length);

        // 商 余
        System.out.println("=================================商 余");
        int sub_a = 5;
        int sub_b = 2;
        System.out.println("商:\t"+sub_a/sub_b);
        System.out.println("余:\t"+sub_a%sub_b);
        System.out.println("double:\t"+(double)1/3);



    }
}
