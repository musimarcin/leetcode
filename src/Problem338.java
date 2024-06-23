//Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
// ans[i] is the number of 1's in the binary representation of i.

import java.util.Arrays;

public class Problem338 {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        int highBit = 1;
        for (int i = 1; i <= n; i++) {
            //checking if i is reaching new highest bit (2,4,8...)
            if (highBit * 2 == i) {
                highBit = i;
            }

            dp[i] = 1 + dp[i - highBit];

//            int count = 0;
//            int tmp = i;
//            while (tmp != 0) {
//                //if mod2 results in 1 it means theres 1 and add it to the result
//                count += tmp % 2;
//                //and shift bit by 1
//                tmp = tmp >> 1;
//            }
//            result[i] = count;
        }
        return dp;
    }
}
