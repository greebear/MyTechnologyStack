package com.greebear.algorithm.leetcodeDoubleMatch.M51.mySolution;

import java.util.HashMap;
import java.util.Map;

public class N5730_replaceDigits
{
    public String replaceDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int v = -1;
        map.put('a',++v);map.put('b',++v);map.put('c',++v);map.put('d',++v);map.put('e',++v);map.put('f',++v);
        map.put('g',++v);map.put('h',++v);map.put('i',++v);map.put('j',++v);map.put('k',++v);map.put('l',++v);
        map.put('m',++v);map.put('n',++v);map.put('o',++v);map.put('p',++v);map.put('q',++v);map.put('r',++v);
        map.put('s',++v);map.put('t',++v);map.put('u',++v);map.put('v',++v);map.put('w',++v);map.put('x',++v);
        map.put('y',++v);map.put('z',++v);
        char[] zimus = {'a', 'b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
                'q','r','s','t','u','v','w','x','y','z'};

        for (int i = 0; i < s.length(); i++) {
            // 奇数
            if(i%2!=0){
                s=shift(map,zimus,s,i);
            }
        }
        return s;
    }

    public String shift(Map<Character, Integer> map, char[] zimus, String s, Integer i){
        char[] chars = s.toCharArray();
        int num = Integer.parseInt(String.valueOf(chars[i]));
        char cur = chars[i-1];
        int cur_index = map.get(cur);
        int next_index = cur_index + num;
        if(next_index>=zimus.length)
            chars[i] = zimus[25];
        else{
            chars[i] = zimus[next_index];
        }
        return new String(chars);
    }

    public static void main(String[] args)
    {
        System.out.println(10%2);
        System.out.println(9%2);

        Map<Character, Integer> map = new HashMap<>();
        int v = -1;
        map.put('a',++v);map.put('b',++v);map.put('c',++v);map.put('d',++v);map.put('e',++v);map.put('f',++v);
        map.put('g',++v);map.put('h',++v);map.put('i',++v);map.put('j',++v);map.put('k',++v);map.put('l',++v);
        map.put('m',++v);map.put('n',++v);map.put('o',++v);map.put('p',++v);map.put('q',++v);map.put('r',++v);
        map.put('s',++v);map.put('t',++v);map.put('u',++v);map.put('v',++v);map.put('w',++v);map.put('x',++v);
        map.put('y',++v);map.put('z',++v);
        System.out.println("get y:" + map.get('y'));
        char[] zimus = {'a', 'b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
                'q','r','s','t','u','v','w','x','y','z'};

        N5730_replaceDigits solution = new N5730_replaceDigits();

        String case_1 = "a1c1e1";
        System.out.println(case_1);
        String output_1_1 = solution.replaceDigits(case_1);
        System.out.println(output_1_1);


        System.out.println("======================");
        String case_2 = "a1b2c3d4e";
        System.out.println(case_2);
        String output_2_2 = solution.replaceDigits(case_2);
        System.out.println(output_2_2);


        System.out.println("==========");
        String aaa = "y9b2c3";
        String bbb = solution.shift(map,zimus,aaa,1);
        System.out.println(bbb);

    }
}
