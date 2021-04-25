package com.atguigu.algorithm;

public class FindNumberIn2DArray
{
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] == target)
                return true;
            if(matrix[i][j] > target){
                i--;
                continue;
            }
            if(matrix[i][j] < target){
                j++;
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[][] array = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean res = findNumberIn2DArray(array, 5);
        System.out.println(res);
    }
}
