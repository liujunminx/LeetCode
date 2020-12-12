package com.leetcode.algorithm.math;

import java.util.HashMap;
import java.util.Map;

public class IntegerRoman {
    private static Map<String, Integer> hashMap = new HashMap<String, Integer>(){{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

    public static String intToRoman(int num){
        System.out.println(hashMap.get(hashMap.size() - 1));
        return "";
    }

    public static void main(String[] args) {
        intToRoman(100);
    }
}
