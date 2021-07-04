package com.leetcode.algorithm.dynamicprogramming;

public class ClimbStairs {
    public int climbStairsII(int n){
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 3; i <= n; i++){
            dp[2] = dp[0] + dp[1];
            dp[1] = dp[0];
            dp[0] = dp[2];
        }
        return dp[2];
    }

    public int climbStairs(int n){
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        if (n <= 2)
            return dp[n];
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairsII(3));
    }
}
