//Given a string s, find the length of the longest substring without repeating characters.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        // set left pointer at the beginning
        int left = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        // set right pointer at the beginning and loop through S string
        for (int right = 0; right < s.length(); right++) {
            // if hashmap has doesnt contain character at current right pointer or its index is less than current left pointer
            // it is a new character, add it to hashmap and calculate new length (result)
            if (!hashMap.containsKey(s.charAt(right)) || hashMap.get(s.charAt(right)) < left) {
                hashMap.put(s.charAt(right), right);
                result = Math.max(result, right - left + 1);
            } else {
                //if not move left pointer to where last time that character appeared (get index from hashmap)
                left = hashMap.get(s.charAt(right)) + 1;
                hashMap.put(s.charAt(right), right);
            }
        }
        return result;
    }
}
