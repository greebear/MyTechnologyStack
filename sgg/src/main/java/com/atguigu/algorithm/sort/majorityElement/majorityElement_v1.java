package com.atguigu.algorithm.sort;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        int limit = nums.length >> 1;
        HashMap<Integer, Integer> map = new HashMap<>(limit);
        for (int num : nums)
            map.merge(num, 1, (o_val, n_val) -> o_val + n_val);
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() > limit)
                return entry.getKey();
        return -1;
    }
}
