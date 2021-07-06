package com.leetcode.algorithm.dynamicprogramming;

public class SellStock {
    /**
     * 求差值，只需要找到最小值和最大值即可。
     * @param prices
     * @return
     */
    public int maxProfitII(int prices[]){
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minprice){
                minprice = prices[i];
            }else if (prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public int maxProfit(int[] prices){
        int n = prices.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if (prices[i] < prices[j]){
                    max = Math.max(max, prices[j]-prices[i]);
                }
            }
        }
        return max;
    }
}
