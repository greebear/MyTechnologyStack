package com.atguigu.algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class N1_twoSum
{
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])) return new int[]{map.get(target-nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[]{0};
    }

    public static void main(String[] args)
    {
        int[] nums = {2,7,11,15};
        int[] res = twoSum(nums, 9);
        System.out.println(Arrays.toString(res));
    }

}
