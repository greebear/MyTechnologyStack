package com.greebear.algorithm.sort.QuickSort;

import java.util.Arrays;

public class Solution
{
    public int[] quickSort(int[] nums) {
        quickSortIntern(nums,0,nums.length-1);
        return nums;
    }

    public void quickSortIntern(int[] nums, int p, int r){
        if(p>=r) return;
        // 找到分区点
        int q = partition_v2(nums,p,r);
        quickSortIntern(nums,p,q-1);
        quickSortIntern(nums,q+1,r);
    }

    // 分区函数
    public int partition(int[] nums, int start, int end){
        int i=start;
        int p = nums[end];
        for (int j = start; j < end; j++) {
            if(nums[j]<p){
                swap(nums, i,j);
                i++;
            }
        }
        swap(nums,i,end);
        return i;
    }
    public int partition_v2(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }
    public void swap(int[] nums, int a, int b){
        int tmp=nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        // 分区测试
        int[] case_1 = {2,3,2};
        int q_1 = solution.partition_v2(case_1,0,case_1.length-1);
        System.out.println(q_1);
        System.out.println(Arrays.toString(case_1));

        int[] case_2 = {2,3,2,2,1,0,0,19,2,3,7,84,3,2,5,10};
        int q_2 = solution.partition(case_2,0,case_2.length-1);
        System.out.println(q_2);
        System.out.println(Arrays.toString(case_2));

        // 快排测试
        System.out.println("=======================");
        int[] case_3 = {2,3,2};
        int[] o_3 = solution.quickSort(case_3);
        System.out.println(Arrays.toString(o_3));

        System.out.println("=======================");
        int[] case_4 = {2,1,3,4,7,8,5,2,5,4};
        int[] o_4 = solution.quickSort(case_4);
        System.out.println(Arrays.toString(o_4));
    }


}
