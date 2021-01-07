package com.leetcode.algorithm.binarysearch;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int hi = row * col - 1;
        int mid = (hi + low) / 2;
        while (hi >= low){
            int temp = matrix[mid / col][mid % col];
            if (target == temp)
                return true;
            else if (target < temp)
                hi = mid - 1;
            else
                low = mid + 1;
            mid = (hi + low) / 2;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        new Search2DMatrix().searchMatrix(matrix, 3);
    }
}
