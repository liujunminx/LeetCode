package com.leetcode.algorithm.twopointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * sliding window
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring01(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0, ans = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstring02(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {// 直接找到滑动窗口的首指针
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring01(s));
        System.out.println(lengthOfLongestSubstring02(s));
    }
}
