package com.leetcode.algorithm.math;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String str = String.valueOf(x);
        int left = 0, right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }

    /**
     * x /= 10 前半部分
     * revertedNumber *= 10 后半部分
     * 前后等价则回文
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            System.out.println(isPalindrome1(123454321));
        }
        long res = System.currentTimeMillis() - start;
        System.out.println(res);
    }
}
