package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 */
public class GenerateParentheses {
    public void backtrace(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2){
            ans.add(cur);
            return;
        }
        if (open < max)
            backtrace(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrace(ans, cur + ")", open, close + 1, max);
    }

    public List<String> generateParenthesis(int n){
        List<String> ans = new ArrayList<>();
        backtrace(ans, "", 0, 0, n);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
