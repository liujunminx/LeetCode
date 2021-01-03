package com.leetcode.algorithm.twopointers;

import java.util.Arrays;

public class ThreeSumCloset {
    /**
     * 指针，比较差值
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumCloset(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int size = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < size - 1 && diff != 0; i++) {
            int left = i + 1;
            int right = size - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                if (sum > target)
                    right--;
                else
                    left++;
            }
        }
        return target - diff;
    }
}
