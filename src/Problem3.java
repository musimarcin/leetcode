//Given a string s, find the length of the longest substring without repeating characters.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            if (!hashMap.containsKey(s.charAt(right)) || hashMap.get(s.charAt(right)) < left) {
                hashMap.put(s.charAt(right), right);
                result = Math.max(result, right - left + 1);
            } else {
                left = hashMap.get(s.charAt(right)) + 1;
                hashMap.put(s.charAt(right), right);
            }
        }
        return result;
    }
}
