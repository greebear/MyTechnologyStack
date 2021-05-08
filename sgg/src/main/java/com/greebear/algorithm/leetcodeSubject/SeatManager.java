package com.greebear.algorithm.leetcodeSubject;

import java.util.HashMap;

public class SeatManager
{
    HashMap<Integer, Boolean> seatMap = new HashMap<>();
    int head=1;
    public SeatManager(int n) {
        for (int i = 1; i <= n; i++) {
            seatMap.put(i, true);
        }
    }

    public int reserve() {
        for (int i = head; i <= seatMap.size() ; i++) {
            if(seatMap.get(i)){
                seatMap.put(i, false);
                head=i;
                return i;
            }
        }
        return 0;
    }

    public void unreserve(int seatNumber) {
        seatMap.put(seatNumber, true);
        if(seatNumber<=head){
            head=seatNumber;
        }
    }

    public static void main(String[] args)
    {
        SeatManager seatManager = new SeatManager(5);


    }
}
