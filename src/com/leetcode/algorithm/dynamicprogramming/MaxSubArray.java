package com.leetcode.algorithm.dynamicprogramming;

public class MaxSubArray {
    public int maxSubArray(int[] nums){
        int pre = 0; int max = nums[0];
        for (int n : nums){
            pre = Math.max(pre+n, n);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        };
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }
}
