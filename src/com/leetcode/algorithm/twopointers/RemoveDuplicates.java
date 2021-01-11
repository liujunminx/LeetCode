package com.leetcode.algorithm.twopointers;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums){
        int oIndex = 0;
        int i = 0;
        while (i < nums.length){
            int sIndex = i;
            while (i < nums.length - 1 && nums[i] == nums[i+1]){
                i++;
            }

            int length = i - sIndex + 1;
            int freq = Math.min(length, 2);

            while (freq-- > 0){
                nums[oIndex++] = nums[sIndex];
            }

            // while循环里是nums[i]==nums[i+1]故需要i++
            i++;
        }

        return oIndex;
    }
}
