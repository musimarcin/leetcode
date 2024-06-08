//Given a string s and a dictionary of strings wordDict, return true
// if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//Note that the same word in the dictionary may be reused multiple times in the segmentation.

import java.util.HashSet;
import java.util.List;

public class Problem139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        //starting from end of string
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                //cheking if word can fit in current [i:] and if word matches
                if (i + word.length() <= s.length() && s.startsWith(word, i)) {
                    //memoize it
                    dp[i] = dp[i + word.length()];
                }
                //if its true already then break from loop to save time
                if (dp[i]) break;
            }
        }
        return dp[0];
    }
}
