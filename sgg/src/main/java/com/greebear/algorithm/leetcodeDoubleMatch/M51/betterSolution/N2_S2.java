package com.greebear.algorithm.leetcodeDoubleMatch.M51.betterSolution;
// https://leetcode-cn.com/circle/discuss/MAuekp/
// https://leetcode-cn.com/problems/seat-reservation-manager/

import java.util.PriorityQueue;

class SeatManagerPriorityQueue {
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int last = 1;
    public void SeatManager(int n) {
//        for (int i = 1; i <=n ; i++) {
//            queue.add(i);
//        }
    }

    public int reserve() {
        if(queue.isEmpty()){
            return last++;
        }
        int key = queue.poll();
        queue.remove(key);
        return key;
    }

    public void unreserve(int seatNumber) {
        queue.add(seatNumber);
    }

    public static void main(String[] args)
    {
//        SeatManagerPriorityQueue seatManagerPriorityQueue = new SeatManagerPriorityQueue(5);

    }
}
