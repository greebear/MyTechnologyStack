package com.atguigu.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutation
{
    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    // 回溯算法
    void dfs(int x){
        // 终止条件
        if(x==c.length){
            return;
        }
        // for
        HashSet<Character> set = new HashSet<>();
        for(int i=x; i <= c.length-1;i++){
            // 作出选择
            if(set.contains(c[i])) continue;
            set.add(c[i]);

            swap(x, i);
            res.add(String.valueOf(c));
            // 递归
            dfs(x+1);
            // 撤销选择
            swap(i, x);
        }


    }

    // 交换
    void swap(int a, int b){
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args)
    {
        String s = "abc";
        Permutation permutation = new Permutation();
        String[] str = permutation.permutation(s);
        System.out.println(Arrays.toString(str));
    }
}
