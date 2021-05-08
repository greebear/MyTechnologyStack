package com.greebear.algorithm.leetcodeSubject.N347;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.merge(num,1, Integer::sum);
        }
        // 初始化小顶堆
        PriorityQueue<Map.Entry<Integer,Integer>> pg = new PriorityQueue<>(
                (x1,x2)->(x2.getValue() - x1.getValue())
        );

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(pg.size()<k){
                pg.add(entry);
            } else if(entry.getValue()>pg.peek().getValue()){
                pg.remove();
                pg.add(entry);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pg.poll().getKey();
        }

        return res;
    }

    public static void main(String[] args)
    {
        PriorityQueue<Integer> pgt = new PriorityQueue<>(
                (x1,x2)->(x2 - x1)
        );

        pgt.add(3);
        pgt.add(2);
        pgt.add(1);

        System.out.println(pgt);
    }
}