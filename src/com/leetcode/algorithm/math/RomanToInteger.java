package com.leetcode.algorithm.math;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private static final Map<Character, Integer> map = new HashMap<Character, Integer>();

    static {
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
    }

    public static int romanToInt(String s) {
        int i = s.length() - 1;
        int sum = 0;
        while (i > 0) {
            int curr = map.get(s.charAt(i));
            int prev = map.get(s.charAt(i - 1));
            sum += curr;
            i--;
            if (curr > prev) {
                sum -= prev;
                i--;
            }
        }
        if (i < 0)
            return sum;
        sum += map.get(s.charAt(0));
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMIII"));
    }
}
