//A message containing letters from A-Z can be encoded into numbers using the following mapping:
//
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
//To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of
// the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
//
//"AAJF" with the grouping (1 1 10 6)
//"KJF" with the grouping (11 10 6)
//Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
//
//Given a string s containing only digits, return the number of ways to decode it.
//
//The test cases are generated so that the answer fits in a 32-bit integer.

import java.util.Arrays;

public class Problem91 {
    public int numDecodings(String s) {
        //base case if there is not string
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int len = s.length();
        // for empty string theres one way to decode
        int prev = 1;
        //checking if first character isnt 0 and ways to decode it
        int preprev = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= len; i++) {
            // get one and two digit numbers behind
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));
            //ways to decode current number
            int curr = 0;

            if (one >= 1 && one <= 9) curr += preprev;
            if (two >= 10 && two <= 26) curr += prev;

            //moving two last elements for next iteration (like adding elements in array)
            prev = preprev;
            preprev = curr;
        }
        return preprev;
    }
}
