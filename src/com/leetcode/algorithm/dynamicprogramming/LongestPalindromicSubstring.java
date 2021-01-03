package com.leetcode.algorithm.dynamicprogramming;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) return s;
        boolean dp[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;// 单个子字符直接为true
        }
        int start = 0, end = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {// 第一个字符与最后一个字符相等，并找出[i,j]之间所有最小回文字符串
                    if (i - j == 1 || dp[j + 1][i - 1]) {// i - j == 1表示这是最小两个字符回文串，dp为true表示往内扩散看子字符串是否为回文串
                        dp[j][i] = true;// 该范围字符串为回文串
                        if (end - start < i - j) {
                            start = j;
                            end = i;
                        }
                    }
                } else {
                    dp[j][i] = false;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String target = "ioajengdabadcdcdadjieoadae";
        System.out.println(longestPalindrome(target));
    }
}
