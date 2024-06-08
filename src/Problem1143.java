//Given two strings text1 and text2, return the length of their longest common subsequence.
// If there is no common subsequence, return 0.
//
//A subsequence of a string is a new string generated from the original string with some characters (can be none)
// deleted without changing the relative order of the remaining characters.
//
//For example, "ace" is a subsequence of "abcde".
//A common subsequence of two strings is a subsequence that is common to both strings.

import java.util.Arrays;

public class Problem1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        //2d programing involves solving it with 2d array and comparing every character at given positions
        int row = text1.length();
        int col = text2.length();
        //2d array is one row/col bigger for out of bounds calculations
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                // if the character matches we add one because it has been found and position diagonally of it
                if (text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    //if not value is calculated base on possible movement(right and down)
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }
        //first position holds result
        return dp[0][0];
    }
}
