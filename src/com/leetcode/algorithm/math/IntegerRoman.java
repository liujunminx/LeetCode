package com.leetcode.algorithm.math;

import java.util.HashMap;
import java.util.Map;

public class IntegerRoman {
    private static final int[] value = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        int len = value.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            while (num >= value[i]) {
                sb.append(symbol[i]);
                num -= value[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(999));
    }
}
