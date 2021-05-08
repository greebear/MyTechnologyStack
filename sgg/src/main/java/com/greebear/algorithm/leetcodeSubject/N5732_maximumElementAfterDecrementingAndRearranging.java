package com.greebear.algorithm.leetcodeSubject;

import java.util.Arrays;

public class N5732_maximumElementAfterDecrementingAndRearranging
{
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] =1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]-arr[i-1]>1){
                arr[i]=arr[i-1]+1;
            }
        }
        return arr[arr.length-1];
    }

    public static void main(String[] args)
    {
        N5732_maximumElementAfterDecrementingAndRearranging solution = new N5732_maximumElementAfterDecrementingAndRearranging();
    }
}
