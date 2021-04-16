package com.atguigu.algorithm.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class majorityElement_v2
{
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        List list = new ArrayList();
        for(int num:nums)
        {
            map.merge(num, 1, (old_val, new_val)->old_val+new_val);
        }
        for(Map.Entry<Integer, Integer> entry:map.entrySet())
        {

            if (entry.getValue() > nums.length/3)
            {
                list.add(entry.getValue());
            }
        }
        return list;
    }

    public static void main(String[] args)
    {
        int[] a_list= new int[]{3,2,3};
        System.out.println();

    }
}
