//You are given an integer array coins representing coins of different denominations and
// an integer amount representing a total amount of money.
//
//Return the fewest number of coins that you need to make up that amount.
// If that amount of money cannot be made up by any combination of the coins, return -1.
//
//You may assume that you have an infinite number of each kind of coin.


import java.util.ArrayList;
import java.util.Arrays;

public class Problem322 {
    public int coinChange(int[] coins, int amount) {
        //every index of dp is amount to get that value
        int[] dp = new int[amount + 1];
        //fills with impossible result
        Arrays.fill(dp, amount + 1);
        //base case as for 0 amount is needed 0 coins
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                // +1 because using a current coin
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
