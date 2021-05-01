package com.atguigu.algorithm;

public class SumBase
{
    public int sumBase(int n, int k) {
        int res=0;
        while(n!=0){
            int value=n%k;
            n = n/k;
            res+=value;
        }
        return res;
    }

    public void main(String[] args)
    {
        int output = sumBase(1,2);
    }
}
