package com.leetcode.algorithm.dynamicprogramming;

public class DecodeWays {
    public int numDecodings(String s){
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0')
            return 0;

        dp[0] = 1;

        for (int i = 1; i < s.length(); i++){
            int tens = s.charAt(i-1) - '0';
            int ones = s.charAt(i) - '0';

            if (ones == 0 && tens != 1 && tens != 2)
                return 0;

            int no = getNo(tens, ones);

            if (no <= 26 && no>= 10){
                if (i >= 2)
                    dp[i] += dp[i-2];
                else
                    dp[i] += 1;
            }

            if (no != 10 && no != 20)
                dp[i] = dp[i] + dp[i-1];
        }

        return dp[s.length()-1];
    }

    public int getNo(int tens, int ones){
        return tens * 10 + ones;
    }
}
