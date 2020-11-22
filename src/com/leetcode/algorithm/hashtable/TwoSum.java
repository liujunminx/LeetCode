package com.leetcode.algorithm.hashtable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {

    /**
     * Brute Force
     * @param nums integers
     * @param target integer
     * @return integers
     */
    public int[] twoSum01(int[] nums, int target){
        int len = nums.length;
        for (int i = 0; i < len; i++){
            int temp = target - nums[i];
            for (int j = len-1; j > i; j--){
                if (temp == nums[j]){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Two pass hashtable
     * we reduce the look up time from O(n) to O(1) by trading space for speed;
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum02(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i){
                return new int[]{i, hashMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * One pass hashtable
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum03(int[] nums, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (hashMap.containsKey(complement)){
                return new int[]{i, hashMap.get(complement)};
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                2, 7, 11, 15
        };
        int target = 9;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum01(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
