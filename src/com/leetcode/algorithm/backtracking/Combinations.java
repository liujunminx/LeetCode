package com.leetcode.algorithm.backtracking;

import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    static List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k){
        backtrack(new ArrayList<Integer>(), 1, n, k);
        return res;
    }

    public void backtrack(List<Integer> currentList, int currentValue, int maximumValue, int listSize){
        if (currentList.size() == listSize){
            res.add(new ArrayList<>(currentList));// 必须要新建一个数组
            return;
        }
        int initialValue = currentValue + listSize - 1 - currentList.size();// 由当前数组动态比较大小
        for (int i = currentValue; i <= maximumValue && initialValue <= maximumValue; i++){
            currentList.add(i);
            backtrack(currentList, i + 1, maximumValue, listSize);
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Combinations().combine(4, 2);
        System.out.println(res.toString());
    }
}
