package com.atguigu.algorithm.sort;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        System.out.println(queue);
        System.out.println(queue.peek());
        queue.poll();   // 出队 -> 元素 1
        queue.poll();   // 出队 -> 元素 2

        System.out.println("=================================双端队列Deque LinkedList<>");
        Deque<Integer> dequeue = new LinkedList<>();
        dequeue.offer(1); // 元素 1 入队
        dequeue.offer(2); // 元素 2 入队
        System.out.println(dequeue);
        System.out.println(dequeue.peek());
        dequeue.poll();   // 出队 -> 元素 1
        dequeue.poll();   // 出队 -> 元素 2
        System.out.println(dequeue.peekFirst());


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


    }
}
