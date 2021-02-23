package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        backtrace(nums, 0, new LinkedList<>());
        return output;
    }

    public void backtrace(int[] nums, int startIndex, LinkedList<Integer> buffer){
        output.add(new ArrayList<>(buffer));
        for (int i = startIndex; i < nums.length; i++){
            if (i > startIndex && nums[i] == nums[i-1]) continue;

            int num = nums[i];
            buffer.add(num);

            backtrace(nums, i + 1, buffer);
            buffer.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 2
        };
        List<List<Integer>> res = new SubsetsII().subsetsWithDup(nums);
        System.out.println(res);
        StringBuffer stringBuffer;
        StringBuilder stringBuilder;
    }
}
