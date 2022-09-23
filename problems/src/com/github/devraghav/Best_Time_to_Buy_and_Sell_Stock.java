package com.github.devraghav;

public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int maxBuy = 0;
        int maxProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            maxBuy = Math.max(maxBuy, prices[i]);
            maxProfit = Math.max(maxProfit, (maxBuy - prices[i]));
        }
        return maxProfit;
    }
}
