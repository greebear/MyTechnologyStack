package com.greebear.algorithm.leetcodeSubject.N554;

import java.util.HashMap;
import java.util.List;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list:wall){
            int sum=0;
            for (Integer integer : list) {
                sum += integer;
                map.merge(sum, 1, (o_val, n_val) -> (o_val + n_val));
            }
            // 删除最后一个
            map.remove(sum);
        }

        // 找到缝隙最大的key
        int max = 0;
        for (Integer key:map.keySet()){
            if(map.get(key)>max) max = map.get(key);
        }
        return wall.size()-max;
    }

    public static void main(String[] args)
    {

    }
}
