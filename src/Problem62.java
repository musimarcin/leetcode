//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
// The robot can only move either down or right at any point in time.
//
//Given the two integers m and n, return the number of possible unique paths
// that the robot can take to reach the bottom-right corner.

import java.util.Arrays;

public class Problem62 {
    public int uniquePaths(int m, int n) {
        //more intuitive
        int[][] dp = new int[m][n];

        //fill out of bounds with 1's
        for(int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //start from new beginning
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                //current field calculation based on previous up and left fields
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];

//        int[] dp = new int[n];
//        //every position takes one way to be there
//        Arrays.fill(dp, 1);
//        for (int i = 0; i < m - 1; i++) {
//            //new array for previous position on grid
//            int[] prev = new int[n];
//            Arrays.fill(prev, 1);
//            //to avoid out of bounds, start from n-2
//            for (int j = n - 2; j >= 0; j--) {
//                //robot can move only down or right, so previous grid can be calculated as moves from those positions
//                prev[j] = prev[j + 1] + dp[j];
//            }
//            //update result array
//            dp = prev;
//        }
//        return dp[0];
    }
}
