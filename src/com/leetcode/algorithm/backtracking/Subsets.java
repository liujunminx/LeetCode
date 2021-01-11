package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    List<List<Integer>> output = new ArrayList<>();
    int n, k;

    public void backtrace(int first, ArrayList<Integer> curr, int[] nums){
        if (curr.size() == k)
            output.add(new ArrayList<>(curr));

        for (int i = first; i < n; i++){
            curr.add(nums[i]);
            backtrace(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums){
        n = nums.length;
        for (k = 0; k < n + 1; k++){
            backtrace(0, new ArrayList<>(), nums);
        }
        return output;
    }
}
