//You are given a string s and an integer k. You can choose any character of the string and change it to
// any other uppercase English character. You can perform this operation at most k times.
//
//Return the length of the longest substring containing the same letter you can get after performing the above operations.

import java.util.HashMap;

public class Problem424 {
    public int characterReplacement(String s, int k) {
       int left = 0;
       int result = 0;
       int freq = 0;
       HashMap<Character, Integer> hashMap = new HashMap<>();
       for (int right = 0; right < s.length(); right++) {
           char cr = s.charAt(right);
           hashMap.put(cr, hashMap.getOrDefault(cr, 0) + 1);
           // get the most frequent character in string
           for (int val : hashMap.values()) {
               freq = Math.max(val, freq);
           }
           // update left side of window while checking if replacements are greater than k and deleting amount of
           // character occurances in hashmap with left pointer
           while (right - left + 1 - freq > k) {
               char cl = s.charAt(left);
               hashMap.put(cl, hashMap.getOrDefault(cl, 0) - 1);
               left += 1;
           }
           // update result with current length if necessary
           result = Math.max(result, right - left + 1);
       }
       return result;
    }
}
