package com.leetcode.algorithm.math;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Note:
 * Assume we are dealing with an environment that
 * could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 * Example 4:
 *
 * Input: x = 0
 * Output: 0
 */
public class ReverseInteger {
    // 未考虑溢出
    public static int reverse01(int x){
        if (x == 0)
            return 0;
        int result = 0;

        int num = Math.abs(x);
        while (num > 0){
            int n = num % 10;
            result = result * 10 + n;
            num /= 10;
        }

        return x > 0? result: result * (-1);
    }

    /**
     * 边界问题
     * @param x
     * @return
     */
    public static int reverse(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
