package com.leetcode.algorithm.twopointers;

/**
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented
 * by array [1,8,6,2,5,4,8,3,7]. In this case,
 * the max area of water (blue section) the container can contain is 49.
 * Example 2:
 */
public class ContainerWithMostWater {
    /**
     * 暴力遍历法
     * @param height
     * @return
     */
    public static int maxArea(int[] height){
        int result = 0;
        for (int i = 0; i < height.length; i++){
            int left = height[i];
            for (int j = i + 1; j < height.length; j++){
                int high = Math.min(left, height[j]);
                int width = j - i;
                int area = high * width;
                if (result < area)
                    result = area;
            }
        }
        return result;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public static int maxArea1(int[] height){
        int maxArea = 0, left = 0, right = height.length - 1;
        // 两个指针
        while (left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])// 最小的一块向内部移动
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 8, 6, 2, 5, 4, 8, 3, 7
        };
        System.out.println(maxArea1(arr));
    }
}
