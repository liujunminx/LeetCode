package com.leetcode.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMaxLength {
    /**
     * 前缀和 哈希表
     * 把0看作-1，则连续数组的和则为0，只要连续数组和为0，则计算下标，并定时更新
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        // 计数器
        int counter = 0;
        int n = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        // 当前缀为空时为-1
        hashMap.put(counter, -1);
        // 最大数
        int max = 0;
        for (int i = 0; i < n; i++){
            int num = nums[i];
            if ( num == 1)
                counter++; // 看作+1
            else
                counter--; // 看作-1
            if (hashMap.containsKey(counter)) {
                // 遇到一次之后在遇到一次说明连续的数组之和为0，此时j-i为数组长度
                int pre = hashMap.get(counter);
                max = Math.max(max, i - pre);
            }else {
                hashMap.put(counter, i);
            }
        }
        return max;
    }
}
