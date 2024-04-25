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
        for (int right = 1; right < prices.length; right++) {
            if (prices[right] - prices[left] < 0) {
                left = right;
            } else {
                tmp = prices[right] - prices[left];
                profit = Math.max(profit, tmp);
            }
        }
        return profit;
    }
}
