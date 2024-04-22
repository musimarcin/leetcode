import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Given an array of strings strs, group the anagrams together. You can return the answer in any order.

public class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String s : strs) {
            // put every character in array, sort it and put into new variable
            char[] letters = s.toCharArray();
            Arrays.sort(letters);
            String sorted = new String(letters);
            // if hashmap doesnt have this word (sorted) put it into hashmap as a key and new array for anagrams
            if (!hashMap.containsKey(sorted)) {
                hashMap.put(sorted, new ArrayList<>());
            }
            // if it contains sorted word as a key it adds current word to array
            hashMap.get(sorted).add(s);
        }
        return new ArrayList<>(hashMap.values());
    }
}
