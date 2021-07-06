package com.leetcode.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex){
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++){
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    curr.add(1);
                }else {
                    curr.add(pre.get(j) + curr.get(j-1));
                }
            }
            pre = curr;
        }
        return pre;
    }
}
