package com.greebear.algorithm.leetcodeSubject;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class MaxProfit
{
    public int maxProfit(int[] prices) {
        int a=1,b=3;
        // f(i) = max(f(i-1), p(i) - min(cost, p(i)))
        int cost = Integer.MAX_VALUE;
        int profit = 0; // f(0)
        for(int price:prices){
            cost = min(cost, price);
            profit = max(profit, price - cost);
        }
        return profit;
    }
}
