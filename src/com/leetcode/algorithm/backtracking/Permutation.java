package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    List<String> res;
    boolean[] vis;

    public String[] permutation(String s){
        int n = s.length();
        res = new ArrayList<String>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        backtrace(arr, 0,n, sb);
        System.out.println(res);
        int size = res.size();
        String[] resArr = new String[size];
        for (int i = 0; i < size; i++){
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public void backtrace(char[] arr, int i, int n, StringBuffer sb){
        if (i == n){
            res.add(sb.toString());
            return;
        }
        for (int j = 0; j < n; j++){
            if (vis[j] || (j>0 && !vis[j-1] && arr[j-1] == arr[j]))
                continue;
            vis[j] = true;
            sb.append(arr[j]);
            backtrace(arr, i + 1, n, sb);
            sb.deleteCharAt(sb.length()-1);
            vis[j] = false;
        }
    }

    public static void main(String[] args) {
        new Permutation().permutation("abc");
    }
}
