package com.greebear.algorithm.leetcodeSingleMatch.M239;

class GetMinDistance {
    public int getMinDistance(int[] nums, int target, int start) {
        int res=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                int tmp = Math.abs(i-start);
                if(tmp<res) res=tmp;
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        GetMinDistance solution = new GetMinDistance();
        int[] aa =  {5,3,6};
        System.out.println(aa[2]);
        int a= solution.getMinDistance(aa,5,2);
        System.out.println(a);
    }
}
