package com.greebear.algorithm.leetcodeSubject;

import java.util.HashMap;
import java.util.Map;

public class IsNumber
{
    public static boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Character,Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<Character,Integer>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<Character,Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap<Character,Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap<Character,Integer>() {{ put('d', 3); }},                                        // 4.
                new HashMap<Character,Integer>() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap<Character,Integer>() {{ put('d', 7); }},                                        // 6.
                new HashMap<Character,Integer>() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap<Character,Integer>() {{ put(' ', 8); }}                                         // 8.
        };

        char t=' ';
        char[] c_list = s.toCharArray();
        int i=0;
        // ' '||'s'||'d'||'.'||'e'
        for(char c:c_list){
            if(c==' ') t=' ';
            if(c=='+'||c=='-') t='s';
            if(c>='0'&&c<='9') t='d';
            if(c=='e'||c=='E') t='e';

            if(states[i].containsKey(t)){
                i = (int) states[i].get(t);
            }
            else{
                return false;
            }
        }

        return false;
    }
}
