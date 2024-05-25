//Given two strings s and t of lengths m and n respectively, return the minimum window substring
// of s such that every character in t (including duplicates) is included in the window. If there is no such substring,
// return the empty string "".

import java.util.HashMap;
import java.util.Objects;

public class Problem76 {
    public String minWindow(String s, String t) {
        int left = 0;
        int len = Integer.MAX_VALUE;
        String result = "";
        // hashmaps for both strings
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        if (s.length() < t.length()) {
            return result;
        }
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c,0) + 1);
        }
        // iterate through s string while adding characters to hashmap
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
            // using helper function to determine if it is potentially substring
            if (isSub(hashMap, tMap)) {
                // update result and remove from hashmap characters outside of the window (moving left side of window)
                while (isSub(hashMap, tMap)) {
                    if (right - left + 1 < len) {
                        len = right - left + 1;
                        result = s.substring(left, right + 1);
                    }
                    char cl = s.charAt(left);
                    hashMap.put(cl, hashMap.getOrDefault(cl, 0) - 1);
                    left += 1;
                }
            }
        }


        return result;
    }
    // helper function to check if hashmap for s string has current character from t string or if theres enough
    // characters appearing
    boolean isSub(HashMap<Character, Integer> hashMap, HashMap<Character, Integer> tMap) {
        for (char c : tMap.keySet()) {
            if (!hashMap.containsKey(c) || hashMap.get(c) < tMap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
