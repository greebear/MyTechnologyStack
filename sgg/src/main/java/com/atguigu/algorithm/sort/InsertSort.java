package com.atguigu.algorithm.sort;
import java.util.Arrays;

public class InsertSort
{
    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }

    public static void main(String[] args)
    {
        int[] data = new int[]{5,4,6,1,3,2};
        insertionSort(data, data.length);
        System.out.println(Arrays.toString(data));
    }
}
