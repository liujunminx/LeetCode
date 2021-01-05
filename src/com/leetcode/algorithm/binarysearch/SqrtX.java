package com.leetcode.algorithm.binarysearch;

public class SqrtX {
    public int mySqrt(int x){
        if (x < 2)
            return x;
        int hi = x, low = 1;
        long mid = low + ((hi - low) / 2);
        while (hi - low > 1) {
            long sq = mid * mid;
            if (sq == x)
                return (int) mid;
            if (sq > x)
                hi = (int) mid;
            else
                low = (int) mid;
            mid = low + ((hi - low) / 2);
        }
        return (int) mid;
    }
}
