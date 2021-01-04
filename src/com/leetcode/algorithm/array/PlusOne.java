package com.leetcode.algorithm.array;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
       int len = digits.length;
       for (int i = len - 1; i >= 0; i--){
           if (digits[i] != 9){
               digits[i]++;
               return digits;// 直接返回
           }else {
               digits[i] = 0;
           }
       }

       int[] arr = new int[len + 1];
       if (digits[0] == 0){
           arr[0] = 1;
           for (int i = 0; i < len; i++){
               arr[i+1] = digits[i];
           }
       }

       return arr;
    }

}
