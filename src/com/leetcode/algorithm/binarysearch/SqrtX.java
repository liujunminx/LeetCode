package com.leetcode.algorithm.binarysearch;

public class SqrtX {
    public int mySqrt(int x){
        int left = 1;
        int right = x;
        int mid = left + (left + right)/2;
        // 排除小数部分只需要跟输入数字比大小即可
        while (right - left > 1){
            int seq = mid * mid;
            if (seq == x)
                return mid;
            else if (seq > x)
                right = mid;
            else
                right = mid;
            mid = left + (left + right) / 2;
        }
        return mid;
    }
}
