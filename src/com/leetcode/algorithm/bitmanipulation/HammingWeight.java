package com.leetcode.algorithm.bitmanipulation;

public class HammingWeight {

    public int hammingWeight(int n) {
        String s = Integer.toString(n, 2);
        System.out.println(s);
        int count = 0;
        for (char c : s.toCharArray()){
            if (c == '1')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new HammingWeight().hammingWeight(9));
    }
}
