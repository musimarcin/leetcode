import java.util.HashMap;
import java.util.Map;

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.

public class Problem242 {
    public boolean isAnagram(String s, String t) {
        HashMap <Character, Integer> anagram = new HashMap<>();
        boolean b = true;
        for (char c : s.toCharArray()) {
            // put every letter of word into hashmap as a key and value as number as many times as it appears
            int count = anagram.getOrDefault(c, 0);
            count += 1;
            anagram.put(c, count);
        }
        for (char c : t.toCharArray()) {
            // if second word contains given letter it subtracts one repetition from hashmap
            anagram.put(c, anagram.getOrDefault(c, 0) - 1);

        }

        for (Map.Entry<Character, Integer> entry : anagram.entrySet()) {
            Character k = entry.getKey();
            Integer v = entry.getValue();
            if (v != 0) {
                return false;
            }
        }
        return b;
    }
}
