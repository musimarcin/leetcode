//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

public class Problem121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0;
        int tmp;
        // set left and right pointer next to each other to create a "window" and check if its not profitable to sell
        // in this window (right - left < 0) then move left to right
        for (int right = 1; right < prices.length; right++) {
            if (prices[right] - prices[left] < 0) {
                left = right;
            } else {
                // if it is profitable then calculate highest profit
                tmp = prices[right] - prices[left];
                profit = Math.max(profit, tmp);
            }
        }
        return profit;
    }
}
